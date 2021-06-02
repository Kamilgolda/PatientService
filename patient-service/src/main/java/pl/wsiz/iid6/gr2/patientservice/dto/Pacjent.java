package pl.wsiz.iid6.gr2.patientservice.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pacjent extends Osoba {

    private int nrUbezpieczenia;
    private Osoba lekarzRodzinny;
    private List<Skierowanie> listaSkierowan;
    private List<Badanie> historiaBadan;
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

    public List<Skierowanie> getListaSkierowan() {
        return listaSkierowan;
    }

    public void AddToListaSkierowan(Skierowanie skierowanie) {
        this.listaSkierowan.add(skierowanie);
    }

    public void setListaSkierowan(List<Skierowanie> listaSkierowan) {
        this.listaSkierowan = listaSkierowan;
    }

    public List<Badanie> getHistoriaBadan() {
        return historiaBadan;
    }

    public void AddToHistoriaBadan(Badanie badanie) {
        this.historiaBadan.add(badanie);
    }

    public void setHistoriaBadan(List<Badanie> historiaBadan) {
        this.historiaBadan = historiaBadan;
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

    public void setSzczepiony(Szczepionka szczepiony) {
        this.szczepiony = szczepiony;
    }

    public Pacjent(String imie, String nazwisko, String miejscowosc, String kod,
                   String ulica, String pesel, LocalDate dataUrodzenia, String mail,
                   String nrTelefonu, Plec plec, int nrUbezpieczenia, Osoba lekarzRodzinny,
                   Szczepionka szczepiony)
    {
        super(imie, nazwisko, miejscowosc, kod, ulica, pesel, dataUrodzenia, mail, nrTelefonu, plec);
        this.nrUbezpieczenia = nrUbezpieczenia;
        this.lekarzRodzinny = lekarzRodzinny;
        this.szczepiony = szczepiony;
        this.recepty = new ArrayList<>();
        this.leki = new ArrayList<>();
        this.historiaBadan = new ArrayList<>();
        this.listaSkierowan = new ArrayList<>();

    }

    public Pacjent(String imie, String nazwisko, String miejscowosc, String kod, String ulica,
                   String pesel, LocalDate dataUrodzenia, String mail, String nrTelefonu, Plec plec,
                   int nrUbezpieczenia, Osoba lekarzRodzinny, List<Skierowanie> listaSkierowan,
                   List<Badanie> historiaBadan, List<Lek> leki, List<Recepta> recepty, Szczepionka szczepiony)
    {
        super(imie, nazwisko, miejscowosc, kod, ulica, pesel, dataUrodzenia, mail, nrTelefonu, plec);
        this.nrUbezpieczenia = nrUbezpieczenia;
        this.lekarzRodzinny = lekarzRodzinny;
        this.listaSkierowan = listaSkierowan;
        this.historiaBadan = historiaBadan;
        this.leki = leki;
        this.recepty = recepty;
        this.szczepiony = szczepiony;
    }
    public Pacjent(String imie, String nazwisko, String pesel) {
        super(imie, nazwisko, pesel);
    }

    public Pacjent(String imie, String nazwisko, String pesel, Integer nrUbezpieczenia) {
        super(imie, nazwisko, pesel);
        this.nrUbezpieczenia =nrUbezpieczenia;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "imie=" + getImie() +
                ", nazwisko="+ getNazwisko() +
                ", pesel=" +getPesel()+
                ", nrUbezpieczenia=" + nrUbezpieczenia +
                ", lekarzRodzinny=" + lekarzRodzinny +
                ", listaSkierowan=" + listaSkierowan +
                ", historiaBadan=" + historiaBadan +
                ", leki=" + leki +
                ", recepty=" + recepty +
                ", szczepiony=" + szczepiony +
                '}';
    }
}
