package pl.wsiz.iid6.gr2.patientservice.dto;

public class Lek {
    private String nazwa;
    private String producent;
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

    public Lek(String nazwa) {
        this.nazwa = nazwa;
    }

    public Lek(String nazwa, String producent) {
        this.nazwa = nazwa;
        this.producent = producent;
    }
}


