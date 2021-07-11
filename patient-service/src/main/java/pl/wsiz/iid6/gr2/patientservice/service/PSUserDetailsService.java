package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.PSUserDetails;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.UserRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PSUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Nie znaleziono: " + userName));

        return user.map(PSUserDetails::new).get();
    }

    public User registerNewUserAccount(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getPesel());
        user.setPassword(userDto.getPassword());
        user.setActive(true);
        user.setRoles("ROLE_PACJENT");

        User newUser = userRepository.save(user);

        PatientEntity newPatient = new PatientEntity(newUser.getId(), userDto.getFirstName(), userDto.getLastName(), newUser.getUserName(), userDto.getMiejscowosc(), userDto.getKod(), userDto.getUlica(), userDto.getDataurodzenia().toLocalDate(), userDto.getEmail(), userDto.getNrtelefonu(), userDto.getPlec());

        patientRepository.save(newPatient);
        return newUser;
    }

//    private boolean emailExist(String email) {
//        return userRepository.findByEmail(email) != null;
//    }
}
