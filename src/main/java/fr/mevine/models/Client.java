package fr.mevine.models;

import java.time.LocalDate;

public class Client {
    private Integer cliId;
    private String numSecuSocial;
    private LocalDate dateNaissance;
    private Mutuelle mutuelle;

    // Constructeurs
    public Client(Integer cliId, String numSecuSocial, LocalDate dateNaissance) {
        this.cliId = cliId;
        this.numSecuSocial = numSecuSocial;
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters
    public int getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getNumSecuSocial() {
        return numSecuSocial;
    }

    public void setNumSecuSocial(String numSecuSocial) {
        this.numSecuSocial = numSecuSocial;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
        this.mutuelle = mutuelle;
    }
}



