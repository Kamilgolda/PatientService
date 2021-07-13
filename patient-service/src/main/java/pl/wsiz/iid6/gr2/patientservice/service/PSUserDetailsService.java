package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Osoba;
import pl.wsiz.iid6.gr2.patientservice.dto.PSUserDetails;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public User registerNewLekarzAccount(UserDto userDto){
        User user = new User();
        user.setUserName(userDto.getPesel());
        user.setPassword(userDto.getPassword());
        user.setActive(true);
        user.setRoles("ROLE_LEKARZ");

        User newUser = userRepository.save(user);

        PatientEntity newPatient = new PatientEntity(newUser.getId(), userDto.getFirstName(), userDto.getLastName(), newUser.getUserName(), userDto.getMiejscowosc(), userDto.getKod(), userDto.getUlica(), userDto.getDataurodzenia().toLocalDate(), userDto.getEmail(), userDto.getNrtelefonu(), userDto.getPlec());

        patientRepository.save(newPatient);
        return newUser;
    }

//    private boolean emailExist(String email) {
//        return userRepository.findByEmail(email) != null;
//    }

    public List<Osoba> findAllDoctors(){
        List<Osoba> lista = new ArrayList<>();
        for(User x: userRepository.findAllByRoles("ROLE_LEKARZ")){
            Optional<PatientEntity> lekarz = patientRepository.findByPesel(x.getUserName());
            if (lekarz.isPresent()) {
                PatientEntity l = lekarz.get();
                lista.add(new Osoba(l.getImie(), l.getNazwisko(), l.getMail(), l.getNrTelefonu(), l.getId().toString()));
            }
        }
        return lista;
    }

    public List<PatientEntity> findAllDoctorsApi(){
        List<PatientEntity> lista = new ArrayList<>();
        for(User x: userRepository.findAllByRoles("ROLE_LEKARZ")){
            Optional<PatientEntity> lekarz = patientRepository.findByPesel(x.getUserName());
            if (lekarz.isPresent()) {
                PatientEntity l = lekarz.get();
                lista.add(l);
            }
        }
        return lista;
    }

    public List<PatientEntity> findAllPatientApi(){
        List<PatientEntity> lista = new ArrayList<>();
        for(PatientEntity x:patientRepository.findAll()){
            lista.add(x);
        }
        return lista;
    }

    public List<PatientEntity> findLekarzByNazwiskoApi(String nazwisko){
        List<PatientEntity> doctors = findAllDoctorsApi();
        List<PatientEntity> patientByName = new ArrayList<>();
        for (PatientEntity patientDoc: doctors){
            String naz = patientDoc.getNazwisko();
            if(naz.equals(nazwisko)) {
                patientByName.add(patientDoc);
            }
        }
        return  patientByName;
    }
    public List<PatientEntity> findByNazwiskoApi(String nazwisko){
        List<PatientEntity> patientByName = new ArrayList<>();
        for (PatientEntity patient: patientRepository.findAllByNazwisko(nazwisko)){
                patientByName.add(patient);
        }
        return  patientByName;
    }

}
