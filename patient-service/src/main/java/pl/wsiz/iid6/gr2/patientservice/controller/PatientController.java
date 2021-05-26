package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping(value = "")
public class PatientController {
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
}
