package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;

import java.util.List;

@Service
public class LekService {

    private Lek[] leki = {new Lek("Ibuprom", "Sanofi"),
                            new Lek("szczepionka", "Astra"),
                            new Lek("Paracetamol", "Polfa")};

    public Lek findLek(String nazwa){
        for(Lek lek: leki){
            if(lek.getNazwa().equals(nazwa)){
                return lek;
            }
        }
        return new Lek(nazwa);
    }

    public List<Lek> getAllLek(){
        return List.of(leki);
    }
}
