package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

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

    public String findByNazwisko(String nazwisko){
        List<PatientEntity> rs = patientRepository.findAllByNazwisko(nazwisko);

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
}
