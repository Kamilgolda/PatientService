package pl.wsiz.iid6.gr2.patientservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsiz.iid6.gr2.patientservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    List<User> findAllByRoles(String Roles);
}
