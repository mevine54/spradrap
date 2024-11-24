package fr.mevine.models;

import java.time.LocalDate;

public class Client extends Utilisateur {
    private String numSecuSocial;
    private LocalDate dateNaissance;
    private Mutuelle mutuelle;

    // Constructeurs
    public Client() {
        super();
    }

    public Client(Integer cliId, String nom, String prenom, Adresse adresse, String telephone, String email,
                  String numSecuSocial, LocalDate dateNaissance, Mutuelle mutuelle) {
        super(cliId, nom, prenom, adresse, telephone, email); // Appel au constructeur parent
        this.numSecuSocial = numSecuSocial;
        this.dateNaissance = dateNaissance;
        this.mutuelle = mutuelle;
    }

    // Getters et Setters
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

    @Override
    public String toString() {
        return super.toString() + ", Numéro de Sécurité Sociale : " + numSecuSocial +
                ", Date de naissance : " + dateNaissance +
                ", Mutuelle : " + (mutuelle != null ? mutuelle.getMutNom() : "Aucune");
    }
}
