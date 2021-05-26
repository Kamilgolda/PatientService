package pl.wsiz.iid6.gr2.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import pl.wsiz.iid6.gr2.patientservice.service.LekService;

import java.util.List;

@Controller
@RequestMapping(value = "/medicine")
public class MedicineController {
    @Autowired
    public LekService lekService;
    @GetMapping(path = "/findMedicine")
    @ResponseBody
    public Lek getMedine(@RequestParam String name){
        return lekService.findLek(name);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Lek> getall(){
        return lekService.getAllLek();
    }
}
