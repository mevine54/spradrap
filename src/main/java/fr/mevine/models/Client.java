package fr.mevine.models;

import java.time.LocalDate;

public class Client extends Utilisateur {
    private Integer cliId;
    private String cliNumSecuSocial;
    private LocalDate cliDateNaissance;
    private Mutuelle mutuelle;
    private Medecin medecin;

    // Constructeurs
    public Client() {
        super();
    }

    public Client(Integer cliId, String utiNom, String utiPrenom, Adresse adresse, String utiTel, String utiEmail,
                  String cliNumSecuSocial, LocalDate cliDateNaissance, Mutuelle mutuelle, Medecin medecin) {
        super(utiNom, utiPrenom, adresse, utiTel, utiEmail); // Appel au constructeur parent
        this.cliId = cliId;
        this.cliNumSecuSocial = cliNumSecuSocial;
        this.cliDateNaissance = cliDateNaissance;
        this.mutuelle = mutuelle;
        this.medecin = medecin;
    }

    // Getters et Setters
    public Integer getCliId() {
        return cliId;
    }

    public void setCliId(Integer cliId) {
        this.cliId = cliId;
    }

    public String getCliNumSecuSocial() {
        return cliNumSecuSocial;
    }

    public void setCliNumSecuSocial(String cliNumSecuSocial) {
        this.cliNumSecuSocial = cliNumSecuSocial;
    }

    public LocalDate getCliDateNaissance() {
        return cliDateNaissance;
    }

    public void setCliDateNaissance(LocalDate cliDateNaissance) {
        this.cliDateNaissance = cliDateNaissance;
    }

    public Mutuelle getMutuelle() {
        return mutuelle;
    }

    public void setMutuelle(Mutuelle mutuelle) {
        this.mutuelle = mutuelle;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numéro de Sécurité Sociale : " + cliNumSecuSocial +
                ", Date de naissance : " + cliDateNaissance +
                ", Mutuelle : " + (mutuelle != null ? mutuelle.getMutNom() : "Aucune") +
                ", Médecin : " + (medecin != null ? medecin.getMedId() : "Aucun");
    }
}
