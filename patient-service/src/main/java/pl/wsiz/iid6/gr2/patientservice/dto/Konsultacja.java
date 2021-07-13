package pl.wsiz.iid6.gr2.patientservice.dto;

public class Konsultacja {
        private String patientpesel;
        private Long lekarzid;
        private String typbadania;
        private String opis;
        private Status status;

        public Konsultacja() {
        }

        public Konsultacja(String patientpesel, Long lekarzid, String typbadania, String opis, Status status) {
                this.patientpesel = patientpesel;
                this.lekarzid = lekarzid;
                this.typbadania = typbadania;
                this.opis = opis;
                this.status = status;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public String getPatientpesel() {
                return patientpesel;
        }

        public void setPatientpesel(String patientpesel) {
                this.patientpesel = patientpesel;
        }

        public Long getLekarzid() {
                return lekarzid;
        }

        public void setLekarzid(Long lekarzid) {
                this.lekarzid = lekarzid;
        }

        public String getTypbadania() {
                return typbadania;
        }

        public void setTypbadania(String typbadania) {
                this.typbadania = typbadania;
        }

        public String getOpis() {
                return opis;
        }

        public void setOpis(String opis) {
                this.opis = opis;
        }
}


