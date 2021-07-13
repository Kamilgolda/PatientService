package pl.wsiz.iid6.gr2.patientservice.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsiz.iid6.gr2.patientservice.dto.Osoba;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;
import pl.wsiz.iid6.gr2.patientservice.service.PSUserDetailsService;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.util.List;


@RestController
@RequestMapping(value= "/api")
public class restApiController {

    @Autowired
    private PSUserDetailsService userService;

    @Autowired
    private LekService lekService;

    @GetMapping(path = "/lekarze", produces ="application/json")
    public List<PatientEntity> alllekarze() {
        return  userService.findAllDoctorsApi();
    }

    @GetMapping(value = "/lekarze/{name}", produces = "application/json")
    public List<PatientEntity> LekarzeByLastName(@PathVariable String name) {
        List<PatientEntity> p = userService.findLekarzByNazwiskoApi(name);
        return p;
    }

    @GetMapping(path="/pacjenci", produces = "application/json")
    public List<PatientEntity> allPatient(){
        return userService.findAllPatientApi();
    }
    @GetMapping(value = "/pacjenci/{name}", produces = "application/json")
    public List<PatientEntity> PacjenciByLastName(@PathVariable String name) {
        List<PatientEntity> p = userService.findByNazwiskoApi(name);
        return p;
    }

    @GetMapping(path = "/leki", produces = "application/json")
    public List<LekEntity> allLeki(){
        return lekService.findAllLekApi();
    }

    @GetMapping(value = "/leki/{name}", produces = "application/json")
    public List<LekEntity> LekiByName(@PathVariable String name) {
        List<LekEntity> l = lekService.findLekByNazwaApi(name);
        return l;
    }

    @GetMapping(path = "/leki/refundowane/{x}", produces = "application/json")
    public List<LekEntity> refundowaneLeki(@PathVariable boolean x){
        return lekService.findAllRefLekApi(x);
    }
}
