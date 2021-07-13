package pl.wsiz.iid6.gr2.patientservice.dto;

public class Konsultacja {
        private String lekarzImie;
        private String lekarzNazwisko;
        private String typbadania;
        private String opis;
        private Status status;

        public Konsultacja() {
        }

        public Konsultacja(String lekarzImie, String lekarzNazwisko, String typbadania, String opis, Status status) {
                this.lekarzImie = lekarzImie;
                this.lekarzNazwisko = lekarzNazwisko;
                this.typbadania = typbadania;
                this.opis = opis;
                this.status = status;
        }

        public String getLekarzImie() {
                return lekarzImie;
        }

        public void setLekarzImie(String lekarzImie) {
                this.lekarzImie = lekarzImie;
        }

        public String getLekarzNazwisko() {
                return lekarzNazwisko;
        }

        public void setLekarzNazwisko(String lekarzNazwisko) {
                this.lekarzNazwisko = lekarzNazwisko;
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

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }
}


