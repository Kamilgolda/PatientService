package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import pl.wsiz.iid6.gr2.patientservice.dto.Osoba;
import pl.wsiz.iid6.gr2.patientservice.dto.UserDto;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.service.PSUserDetailsService;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private PSUserDetailsService userService;

    @GetMapping("/dodaj")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registerLekarz";
    }

    @RequestMapping( value = "/registration", method = RequestMethod.POST)
    public String registerLekarzAccount(
            @Validated @ModelAttribute("user")UserDto userDto,
            BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "error";
        }

        try {
            User registered = userService.registerNewLekarzAccount(userDto);
        } catch (UsernameNotFoundException ex) {
            ex.printStackTrace();
        }

        return "profile";
    }
}
