package fr.mevine.models;

public class Medecin extends Utilisateur {
    Integer medId;
    private String numeroAgrement;

    // Constructeurs
    public Medecin() {
    }

    public Medecin(Integer medId, String nom, String prenom, String telephone, String email, Adresse adresse, String numeroAgrement) {
        super(medId, nom, prenom, adresse, telephone, email);
        this.numeroAgrement = numeroAgrement;
    }

    // Getters et Setters
    public  Integer getMedId() {
        return medId;
    }

    public  void setMedId() {
        this.medId = medId;
    }
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
