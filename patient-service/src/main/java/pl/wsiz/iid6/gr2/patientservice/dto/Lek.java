package pl.wsiz.iid6.gr2.patientservice.dto;

public class Lek {
    private String nazwa;
    private String producent;
    private int cena;
    private boolean refundowany;

    public String getNazwa() {
        return nazwa;
    }

    public String getProducent() {
        return producent;
    }

    public boolean isRefundowany() {
        return refundowany;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    public Lek(String nazwa) {
        this.nazwa = nazwa;
    }

    public Lek(String nazwa, String producent) {
        this.nazwa = nazwa;
        this.producent = producent;
    }

    public Lek(String nazwa, String producent, int cena, boolean refundowany) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.cena = cena;
        this.refundowany = refundowany;
    }

    @Override
    public String toString() {
        return "Lek{" +
                "nazwa='" + nazwa + '\'' +
                ", producent='" + producent + '\'' +
                ", cena=" + cena +
                ", refundowany=" + refundowany +
                '}';
    }
}


