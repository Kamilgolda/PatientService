package pl.wsiz.iid6.gr2.patientservice.dto;

import java.util.Date;
import java.util.List;

public class Recepta {
    private int ID;
    private String peselPacjenta;
    private Date dataWaznosci;
    private List<Lek> listaLekow;
    private Osoba lekarz;
}
