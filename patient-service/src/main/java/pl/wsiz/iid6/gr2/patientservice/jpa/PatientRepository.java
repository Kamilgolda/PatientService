package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends CrudRepository<PatientEntity, Long> {
    List<PatientEntity> findAll();
    List<PatientEntity> findAllByNazwisko(String lastName);
    Optional<PatientEntity> findByPesel(String Pesel);
}
