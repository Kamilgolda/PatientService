package pl.wsiz.iid6.gr2.patientservice.dto;

public enum Stan {
    normalny(true), podgoraczkowy(false), goraczkowy(false);
    boolean zdrowy;

    Stan(boolean czyOK){
        zdrowy = czyOK;
    }
}
