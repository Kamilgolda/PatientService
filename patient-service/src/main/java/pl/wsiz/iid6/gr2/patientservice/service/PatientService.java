package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.*;
import pl.wsiz.iid6.gr2.patientservice.entity.KonsultacjaEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.jpa.KonsultacjaRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private KonsultacjaRepository konsultacjaRepository;

    public Pacjent findbyId(Long id) {
        Optional<PatientEntity> res = patientRepository.findById(id);
        if (res.isPresent()) {
            PatientEntity patientEntity = res.get();
            return new Pacjent(patientEntity.getImie(),patientEntity.getNazwisko(),
                    patientEntity.getMiejscowosc(),patientEntity.getKod(),patientEntity.getUlica(),
                    patientEntity.getPesel(), patientEntity.getDataUrodzenia(), patientEntity.getMail(),
                    patientEntity.getNrTelefonu(), patientEntity.getPlec(), patientEntity.getNrubezpieczenia(),
                    patientEntity.getSzczepiony());
        }
        return new Pacjent();
    }

    public Pacjent findByPesel(String pesel){
        Optional<PatientEntity> res = patientRepository.findByPesel(pesel);
        if (res.isPresent()) {
            PatientEntity patient = res.get();
            return new Pacjent(patient.getImie(), patient.getNazwisko(), patient.getMiejscowosc(), patient.getKod(),
                        patient.getUlica(), patient.getPesel(), patient.getDataUrodzenia(), patient.getMail(),
                        patient.getNrTelefonu(), patient.getPlec(), patient.getNrUbezpieczenia(), patient.getSzczepiony());
        }
        return new Pacjent();
    }



    public String findByNazwisko(String nazwisko){

        List<Pacjent> Patients = new ArrayList<>();
        try {
            for (PatientEntity patientEntity: patientRepository.findAllByNazwisko(nazwisko)){
                Pacjent pacjent = new Pacjent(patientEntity.getImie(),patientEntity.getNazwisko(),
                        patientEntity.getMiejscowosc(),patientEntity.getKod(),patientEntity.getUlica(),
                        patientEntity.getPesel(), patientEntity.getDataUrodzenia(), patientEntity.getMail(),
                        patientEntity.getNrTelefonu(), patientEntity.getPlec(), patientEntity.getNrubezpieczenia(),
                        patientEntity.getSzczepiony());
                Patients.add(pacjent);
        }
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        if(Patients.size()<1) return "Wystąpił błąd lub podano nieprawidłowy argument";
        return Patients.toString();
    }

    public KonsultacjaEntity registerNewConsultation(String patientpesel, Long lekarz_id){
        KonsultacjaEntity consultation = new KonsultacjaEntity();
        consultation.setPatientpesel(patientpesel);
        consultation.setLekarzid(lekarz_id);
        consultation.setOpis("");
        consultation.setTypbadania("");
        consultation.setStatus(Status.OCZEKUJACA);

        KonsultacjaEntity newConsultation = konsultacjaRepository.save(consultation);

        return newConsultation;
    }

    public List<Konsultacja> findKonsultacjaByPesel(String pesel){
        List<Konsultacja> lista = new ArrayList<>();
        for(KonsultacjaEntity x: konsultacjaRepository.findAllByPatientpesel(pesel)){
            Optional<PatientEntity> lekarz = patientRepository.findById(x.getLekarzid());
            if (lekarz.isPresent()) {
                PatientEntity l = lekarz.get();
                lista.add(new Konsultacja(l.getImie(), l.getNazwisko(), x.getTypbadania(), x.getOpis(), x.getStatus()));
            }
        }
        return lista;
    }


}
