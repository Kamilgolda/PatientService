package pl.wsiz.iid6.gr2.patientservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Lek")
public class LekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    public LekEntity(String nazwa) {
        this.nazwa = nazwa;
    }

    public LekEntity(String nazwa, String producent) {
        this.nazwa = nazwa;
        this.producent = producent;
    }

    public Long getId() {
        return id;
    }

    public LekEntity(String nazwa, String producent, int cena, boolean refundowany) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.cena = cena;
        this.refundowany = refundowany;
    }

    public LekEntity() {
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
