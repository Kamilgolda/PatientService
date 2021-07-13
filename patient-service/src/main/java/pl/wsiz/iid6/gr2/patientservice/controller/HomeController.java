package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import pl.wsiz.iid6.gr2.patientservice.dto.Osoba;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.service.PSUserDetailsService;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private PSUserDetailsService userService;

    @GetMapping(path="")
    public String homepage(final ModelMap model) throws Exception {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "register";
    }

    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String registerUserAccount(
            @Validated @ModelAttribute("user")UserDto userDto,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        try {
            User registered = userService.registerNewUserAccount(userDto);
        } catch (UsernameNotFoundException ex) {
            ex.printStackTrace();
        }

        return "home";
    }

    @GetMapping(path="/lekarze")
    public String lekarze(final ModelMap model) throws Exception {
        List<Osoba> lekarze = userService.findAllDoctors();
        model.addAttribute("doctors", lekarze);
        return "lekarze";
    }

    @GetMapping(path="/telefony")
    public String telefony(final ModelMap model) throws Exception {
        return "spis_tel";
    }
}
