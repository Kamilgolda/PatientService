package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.KonsultacjaEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;

public interface KonsultacjaRepository extends CrudRepository<KonsultacjaEntity, Long> {

}
