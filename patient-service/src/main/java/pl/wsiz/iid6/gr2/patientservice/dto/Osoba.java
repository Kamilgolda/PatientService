package pl.wsiz.iid6.gr2.patientservice.dto;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Osoba {

    public static void main(String[] args) {
    Osoba os = new Osoba();
    os.setImie("kamil");
    os.setNrTelefonu("123456789");
    os.pesel="98032709297";
    os.setDataUrodzenia(LocalDate.of(1998,3,27));
    os.plec=Plec.Mężczyzna;
    System.out.println(os.checkPesel());
    os.mail="kamil.goldaat@gmail.com";
        System.out.println(os.checkEmail());
        System.out.println(os.getWiek());
        System.out.println(os.getImie());
    }
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

    public boolean checkEmail(){
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

    public void setPlec(Plec plec) {
        this.plec = plec;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(@NotNull String nrTelefonu) {
        if (nrTelefonu.length() < 12) this.nrTelefonu = nrTelefonu;
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
        this.kod = kod;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica.substring(0, 1).toUpperCase() + ulica.substring(1);;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        if (dataUrodzenia.compareTo(LocalDate.now()) < 0)
        this.dataUrodzenia = dataUrodzenia;
    }
}
