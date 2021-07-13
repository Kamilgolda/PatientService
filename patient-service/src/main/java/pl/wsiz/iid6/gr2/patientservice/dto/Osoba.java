package pl.wsiz.iid6.gr2.patientservice.dto;

import net.bytebuddy.implementation.bytecode.Throw;

import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Osoba{

    private String imie;
    private String nazwisko;
    private String miejscowosc;
    private String kod;
    private String ulica;
    private String pesel;
    private LocalDate dataUrodzenia;
    private String mail;
    private String nrTelefonu;
    private Plec plec;

    public boolean checkEmail(String mail){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }

    public boolean checkPesel() {

        if (pesel.length() != 11 || plec==null || dataUrodzenia==null) return false;

        /*
        Jeżeli trzecia cyfra jest równa 0 lub 1, do roku dodajemy 1900
        Jeżeli trzecia cyfra jest równa 2 lub 3, do roku dodajemy 2000
        Jeżeli trzecia cyfra jest równa 4 lub 5, do roku dodajemy 2100
        Jeżeli trzecia cyfra jest równa 6 lub 7, do roku dodajemy 2200
        Jeżeli trzecia cyfra jest równa 8 lub 9, do roku dodajemy 1800
        */

        String rrrr = pesel.substring(0, 2);
        String mmmm = pesel.substring(2, 4);
        String dddd = pesel.substring(4, 6);
        int p = pesel.charAt(9);
        Plec plecInPesel= null;

        if (p % 2 == 0) plecInPesel=Plec.Kobieta;
        else plecInPesel = Plec.Mężczyzna;

        String dataInPesel;

        if (pesel.charAt(2) == '2' || pesel.charAt(2) == '3') {
            if (pesel.charAt(2) == '3') dataInPesel = (dddd + "-1" + (Integer.parseInt(mmmm) - 20) + "-20" + rrrr);
            else dataInPesel = (dddd + "-0" + (Integer.parseInt(mmmm) - 20) + "-20" + rrrr);
        }
        else dataInPesel = (dddd + "-" + mmmm + "-19" + rrrr);

        return Integer.parseInt(dataInPesel.substring(0, 2)) == dataUrodzenia.getDayOfMonth() &&
                Integer.parseInt(dataInPesel.substring(3, 5)) == dataUrodzenia.getMonthValue() &&
                Integer.parseInt(dataInPesel.substring(6, 10)) == dataUrodzenia.getYear() &&
                plec.equals(plecInPesel);
    }

    public Plec getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        if (plec == 'M') this.plec = Plec.Mężczyzna;
        else if(plec == 'K') this.plec = Plec.Kobieta;
        else throw new InputMismatchException("Nieprawidłowa plec");
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        if (checkEmail(mail))   this.mail = mail;
        else throw new InputMismatchException("Nieprawidłowy adres email");
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        if (nrTelefonu.length() <= 12 && nrTelefonu.length() >=9 ) this.nrTelefonu = nrTelefonu;
        else throw new InputMismatchException("Nieprawidłowy numer telefonu");
    }

    public int getWiek(){
        Period wiek = Period.between(dataUrodzenia,LocalDate.now());
        return wiek.getYears();
    }
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie.substring(0, 1).toUpperCase() + imie.substring(1);
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko.substring(0, 1).toUpperCase() + nazwisko.substring(1);
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc.substring(0, 1).toUpperCase() + miejscowosc.substring(1);
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        if (kod.length() == 6 && kod.charAt(2) == '-')this.kod = kod;
        else throw new InputMismatchException("Nieprawidłowy kod pocztowy!");
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        if(ulica==null) this.ulica="-";
        else
        this.ulica = ulica.substring(0, 1).toUpperCase() + ulica.substring(1);;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel)
    {
      if (pesel.length() == 11) this.pesel = pesel;
      else throw new InputMismatchException("Nieprawidłowy pesel");
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        if (dataUrodzenia.compareTo(LocalDate.now()) < 0)
            this.dataUrodzenia = dataUrodzenia;
        else throw new InputMismatchException("Nieprawidłowa data urodzenia");
    }

    public Osoba(String imie, String nazwisko, String miejscowosc, String kod, String ulica, String pesel, LocalDate dataUrodzenia, String mail, String nrTelefonu, char plec) {
        setImie(imie);
        setNazwisko(nazwisko);
        setMiejscowosc(miejscowosc);
        setKod(kod);
        setUlica(ulica);
        setPesel(pesel);
        setDataUrodzenia(dataUrodzenia);
        setMail(mail);
        setNrTelefonu(nrTelefonu);
        setPlec(plec);
        if (!checkPesel()) throw new InputMismatchException("Wprowadzone dane się nie zgadzają");
    }

    public Osoba(String imie, String nazwisko, String mail, String nrTelefonu, String Id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mail = mail;
        this.nrTelefonu = nrTelefonu;
        this.pesel = Id;
    }

    public Osoba() {
    }
}
