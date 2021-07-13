package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.iid6.gr2.patientservice.dto.Konsultacja;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.KonsultacjaEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.service.DoctorService;
import pl.wsiz.iid6.gr2.patientservice.service.PatientService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "/lekarz")
public class DoctorController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(path="/konsultacje")
    public String konsultacje(final ModelMap model, Principal principal) throws Exception {

        String pesel = principal.getName();
        List<Konsultacja> konsultacje = doctorService.findKonsultacjaByDoctorPesel(pesel);
        model.addAttribute("consultations", konsultacje);
        return "konsultacje";
    }

    @GetMapping(value = "/konsultacje/{idP}")
    public String konsultacja_finish(final ModelMap model, @PathVariable Long idP) throws Exception {
        KonsultacjaEntity k = doctorService.getConsultationById(idP);
        model.addAttribute("consultation", k);
        return "konsultacja-edit";
    }

    @RequestMapping( value = "/konsultacje/edit", method = RequestMethod.POST)
    public String consultationEdit(
            @ModelAttribute("consultation") KonsultacjaEntity konsultacjaEntity,
            final ModelMap model) {

        try {
            KonsultacjaEntity konsultacja = doctorService.consultationEdit(konsultacjaEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "home";
    }
}
