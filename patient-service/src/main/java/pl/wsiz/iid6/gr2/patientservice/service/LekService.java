package pl.wsiz.iid6.gr2.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.iid6.gr2.patientservice.dto.Lek;
import pl.wsiz.iid6.gr2.patientservice.entity.LekEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.PatientEntity;
import pl.wsiz.iid6.gr2.patientservice.entity.User;
import pl.wsiz.iid6.gr2.patientservice.jpa.LekRepository;
import pl.wsiz.iid6.gr2.patientservice.jpa.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LekService {

    @Autowired
    private LekRepository lekRepository;

    public List<LekEntity> findAllLekApi(){
        List<LekEntity> lista = new ArrayList<>();
        for(LekEntity x:lekRepository.findAll()){
            lista.add(x);
        }
        return lista;
    }

    public List<LekEntity> findAllRefLekApi(boolean val){
        List<LekEntity> lista = new ArrayList<>();
        for(LekEntity x:lekRepository.findAll()){
            if(x.isRefundowany() == val)
            lista.add(x);
        }
        return lista;
    }

    public List<LekEntity> findLekByNazwaApi(String nazwa){
        List<LekEntity> LekByName = new ArrayList<>();
        for (LekEntity lek: lekRepository.findAllByNazwa(nazwa)){
            LekByName.add(lek);
        }
        return  LekByName;
    }
//    public Lek findLek(String nazwa){
//        for(Lek lek: leki){
//            if(lek.getNazwa().equals(nazwa)){
//                return lek;
//            }
//        }
//        return new Lek(nazwa);
//    }
}
