package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping(path="")
    public String homepage(final ModelMap model) throws Exception {
        return "home.html";
    }
}
