package pl.wsiz.iid6.gr2.patientservice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Pacjent extends Osoba {

    private int nrUbezpieczenia;
    private Osoba lekarzRodzinny;
    private List<Lek> leki;
    private List<Recepta> recepty;
    private Szczepionka szczepiony;

    public int getNrUbezpieczenia() {
        return nrUbezpieczenia;
    }

    public void setNrUbezpieczenia(int nrUbezpieczenia) {
        this.nrUbezpieczenia = nrUbezpieczenia;
    }

    public Osoba getLekarzRodzinny() {
        return lekarzRodzinny;
    }

    public void setLekarzRodzinny(Osoba lekarzRodzinny) {
        this.lekarzRodzinny = lekarzRodzinny;
    }

    public List<Lek> getLeki() {
        return leki;
    }

    public void AddToLeki(Lek lek){
        this.leki.add(lek);
    }
    public void setLeki(List<Lek> leki) {
        this.leki = leki;
    }

    public List<Recepta> getRecepty() {
        return recepty;
    }

    public void AddToRecepty(Recepta recepta){
        this.recepty.add(recepta);
    }
    public void setRecepty(List<Recepta> recepty) {
        this.recepty = recepty;
    }

    public Szczepionka getSzczepiony() {
        return szczepiony;
    }

    public void setSzczepiony(char szczepiony) {

        if(szczepiony == 'P') this.szczepiony=Szczepionka.Pfizer;
        else if(szczepiony == 'M') this.szczepiony=Szczepionka.Moderna;
        else if(szczepiony == 'A') this.szczepiony=Szczepionka.AstraZeneca;
        else if(szczepiony == 'J') this.szczepiony=Szczepionka.Janssen;
        else if(szczepiony == 'B') this.szczepiony=Szczepionka.Brak;
        else throw new InputMismatchException("Blad szczepiony");
    }

    public Pacjent(String imie, String nazwisko, String miejscowosc, String kod,
                   String ulica, String pesel, LocalDate dataUrodzenia, String mail,
                   String nrTelefonu, char plec, int nrUbezpieczenia, char szczepiony)
    {
        super(imie, nazwisko, miejscowosc, kod, ulica, pesel, dataUrodzenia, mail, nrTelefonu, plec);
        this.nrUbezpieczenia = nrUbezpieczenia;
        this.setSzczepiony(szczepiony);
        this.recepty = new ArrayList<>();
        this.leki = new ArrayList<>();
    }

    public Pacjent() {
        super();
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "imie=" + getImie() +
                ", nazwisko="+ getNazwisko() +
                ", pesel=" +getPesel()+
                ", nrUbezpieczenia=" + nrUbezpieczenia +
                ", lekarzRodzinny=" + lekarzRodzinny +
                ", leki=" + leki +
                ", recepty=" + recepty +
                ", szczepiony=" + szczepiony +
                '}';
    }
}
