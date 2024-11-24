package fr.mevine.models;

public class Medecin extends Utilisateur {
    private String numeroAgrement;

    // Constructeurs
    public Medecin() {
    }

    public Medecin(Integer medId, String nom, String prenom, String telephone, String email, Adresse adresse, String numeroAgrement) {
        super(medId, nom, prenom, adresse, telephone, email);
        this.numeroAgrement = numeroAgrement;
    }

    // Getters et Setters
    public String getNumeroAgrement() {
        return numeroAgrement;
    }

    public void setNumeroAgrement(String numeroAgrement) {
        this.numeroAgrement = numeroAgrement;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numéro d'agrément : " + numeroAgrement;
    }
}
