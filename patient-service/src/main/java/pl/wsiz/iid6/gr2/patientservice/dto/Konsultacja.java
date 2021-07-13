package pl.wsiz.iid6.gr2.patientservice.dto;

public class Konsultacja {
        private Long id;
        private String lekarzImie;
        private String lekarzNazwisko;
        private String pacjentImie;
        private String pacjentNazwisko;
        private String pacjentPesel;
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

        public Konsultacja(Long id, String pacjentImie, String pacjentNazwisko, String pacjentPesel, String typbadania, String opis, Status status) {
                this.id = id;
                this.pacjentImie = pacjentImie;
                this.pacjentNazwisko = pacjentNazwisko;
                this.pacjentPesel = pacjentPesel;
                this.typbadania = typbadania;
                this.opis = opis;
                this.status = status;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getPacjentImie() {
                return pacjentImie;
        }

        public void setPacjentImie(String pacjentImie) {
                this.pacjentImie = pacjentImie;
        }

        public String getPacjentNazwisko() {
                return pacjentNazwisko;
        }

        public void setPacjentNazwisko(String pacjentNazwisko) {
                this.pacjentNazwisko = pacjentNazwisko;
        }

        public String getPacjentPesel() {
                return pacjentPesel;
        }

        public void setPacjentPesel(String pacjentPesel) {
                this.pacjentPesel = pacjentPesel;
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


