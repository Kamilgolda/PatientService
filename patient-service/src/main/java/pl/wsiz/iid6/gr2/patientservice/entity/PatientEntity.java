package pl.wsiz.iid6.gr2.patientservice.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "patient")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int userid;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String miejscowosc;
    private String kod;
    private String ulica;
    private LocalDate dataurodzenia;
    private String mail;
    private String nrtelefonu;
    private char plec;
    private int nrubezpieczenia;
    private Long idlekarzrodzinny;
    private char szczepiony;

    public PatientEntity() {
    }

    public LocalDate getDataurodzenia() {
        return dataurodzenia;
    }

    public void setDataurodzenia(LocalDate dataurodzenia) {
        this.dataurodzenia = dataurodzenia;
    }

    public String getNrtelefonu() {
        return nrtelefonu;
    }

    public void setNrtelefonu(String nrtelefonu) {
        this.nrtelefonu = nrtelefonu;
    }

    public int getNrubezpieczenia() {
        return nrubezpieczenia;
    }

    public void setNrubezpieczenia(int nrubezpieczenia) {
        this.nrubezpieczenia = nrubezpieczenia;
    }

    public Long getIdlekarzrodzinny() {
        return idlekarzrodzinny;
    }

    public void setIdlekarzrodzinny(Long idlekarzrodzinny) {
        this.idlekarzrodzinny = idlekarzrodzinny;
    }

    public char getSzczepiony() {
        return szczepiony;
    }

    public void setSzczepiony(char szczepiony) {
        this.szczepiony = szczepiony;
    }

    public PatientEntity(int userid, String imie, String nazwisko, String pesel, String miejscowosc, String kod, String ulica, LocalDate dataUrodzenia, String mail, String nrTelefonu, char plec) {
        this.userid = userid;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.miejscowosc = miejscowosc;
        this.kod = kod;
        this.ulica = ulica;
        this.dataurodzenia = dataUrodzenia;
        this.mail = mail;
        this.nrtelefonu = nrTelefonu;
        this.plec= plec;
        this.nrubezpieczenia=0;
        this.idlekarzrodzinny= (long)0;
        this.szczepiony='B';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setNrUbezpieczenia(Integer nrUbezpieczenia) {
        this.nrubezpieczenia = nrUbezpieczenia;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public LocalDate getDataUrodzenia() {
        return dataurodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataurodzenia = dataUrodzenia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNrTelefonu() {
        return nrtelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrtelefonu = nrTelefonu;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public Long getId() {
        return id;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getPesel() {
        return pesel;
    }

    public Integer getNrUbezpieczenia() {
        return nrubezpieczenia;
    }

    @Override
    public String toString() {
        return String.format(
                "Patient[id=%d, firstName='%s', lastName='%s' pesel='%s',miejscowosc='%s',kod='%s',ulica='%s',data_urodzenia='%s',mail='%s',nr_telefonu='%s',plec='%s']",
                id, imie, nazwisko, pesel, miejscowosc, kod, ulica, dataurodzenia, mail, nrtelefonu, plec);
    }
}