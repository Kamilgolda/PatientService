package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.iid6.gr2.patientservice.dto.Osoba;
import pl.wsiz.iid6.gr2.patientservice.dto.Pacjent;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.service.PSUserDetailsService;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.List;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private PSUserDetailsService userService;

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

    @GetMapping(path="/konsultacja")
    public String konsultacja(final ModelMap model) throws Exception {

        List<Osoba> lekarze = userService.findAllDoctors();
        model.addAttribute("doctors", lekarze);
        return "konsultacja";
    }

    @GetMapping(value = "/konsultacja/{idP}")
    public String konsultacja_finish(final ModelMap model, @PathVariable Long idP, Principal principal) throws Exception {
        String pesel = principal.getName();
        patientService.registerNewConsultation(pesel, idP);
        return "konsultacja-finish";
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
