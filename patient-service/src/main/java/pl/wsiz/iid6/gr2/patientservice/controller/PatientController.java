package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(path="")
    public String userdata(final ModelMap model, Principal principal) throws Exception {

        String pesel = principal.getName();
        try{
            Pacjent pacjent = patientService.findByPesel(pesel);
            model.addAttribute("warning", "");
            model.addAttribute("plec", pacjent.getPlec());
            model.addAttribute("imie", pacjent.getImie());
            model.addAttribute("nazwisko", pacjent.getNazwisko());
            model.addAttribute("miejscowosc", pacjent.getMiejscowosc());
            model.addAttribute("kod", pacjent.getKod());
            model.addAttribute("ulica", pacjent.getUlica());
            model.addAttribute("pesel", pacjent.getPesel());
            model.addAttribute("dataurodzenia", pacjent.getDataUrodzenia());
            model.addAttribute("mail", pacjent.getMail());
            model.addAttribute("nrtel", pacjent.getNrTelefonu());
            model.addAttribute("nrubezpieczenia", pacjent.getNrUbezpieczenia());

        }
        catch (InputMismatchException exception){
            model.addAttribute("warning", exception.getMessage());
            model.addAttribute("plec", "");
            model.addAttribute("imie", "");
            model.addAttribute("nazwisko", "");
            model.addAttribute("miejscowosc", "");
            model.addAttribute("kod", "");
            model.addAttribute("ulica", "");
            model.addAttribute("pesel", "");
            model.addAttribute("dataurodzenia", "");
            model.addAttribute("mail", "");
            model.addAttribute("nrtel", "");
            model.addAttribute("nrubezpieczenia", "");
        }
        return "profile";
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
