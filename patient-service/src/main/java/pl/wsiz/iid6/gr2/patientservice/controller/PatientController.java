package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/hej")
    @ResponseBody
    public String witaj(@RequestParam String name){
        return "Witaj w naszej przychodni "+name;
    }

    @GetMapping(path = "/pa")
    @ResponseBody
    public String pa(){
        return "Do zobaczenia <p>następnym razem</>";
    }

    @GetMapping(path = "/wiek")
    @ResponseBody
    public String wiek(@RequestParam(required = true) int ru, @RequestParam(required = false) int rs) {
        return Integer.toString(rs-ru);
    }

    @GetMapping(path ="/id")
    @ResponseBody
    public String patientId(@RequestParam Long idP){
        return (patientService.findbyId(idP)).toString();
    }

    @GetMapping(path ="/lnames")
    @ResponseBody
    public String patientLastName(@RequestParam String lname){
        return patientService.findByNazwisko(lname);
    }
}
