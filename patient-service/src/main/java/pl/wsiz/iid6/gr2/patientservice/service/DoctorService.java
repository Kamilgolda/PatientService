package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Konsultacja;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.KonsultacjaEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.jpa.KonsultacjaRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private KonsultacjaRepository konsultacjaRepository;

    public List<Konsultacja> findKonsultacjaByDoctorPesel(String pesel){
        List<Konsultacja> lista = new ArrayList<>();
        Optional<PatientEntity> lekarz = patientRepository.findByPesel(pesel);
        if (lekarz.isPresent()) {
            PatientEntity l = lekarz.get();

            for (KonsultacjaEntity x : konsultacjaRepository.findAllByLekarzid(l.getId())) {
                Optional<PatientEntity> pacjent = patientRepository.findByPesel(x.getPatientpesel());
                if (pacjent.isPresent()) {
                    PatientEntity p = pacjent.get();

                    lista.add(new Konsultacja(x.getId(), p.getImie(), p.getNazwisko(), p.getPesel(), x.getTypbadania(), x.getOpis(), x.getStatus()));
                }
            }
        }
        return lista;
    }

    public KonsultacjaEntity getConsultationById(Long id) {
        Optional<KonsultacjaEntity> konsultacja = konsultacjaRepository.findById(id);
        if (konsultacja.isPresent()) {
            KonsultacjaEntity k = konsultacja.get();
            return k;
        }
        return new KonsultacjaEntity();
    }

    public KonsultacjaEntity consultationEdit(KonsultacjaEntity konsultacjaEntity){
//        User user = new User();
//        user.setUserName(userDto.getPesel());
//        user.setPassword(userDto.getPassword());
//        user.setActive(true);
//        user.setRoles("ROLE_PACJENT");

        KonsultacjaEntity konsultacja = konsultacjaRepository.save(konsultacjaEntity);

        return konsultacja;
    }
}
