package fr.mevine.models;

public class Posseder {
    private int ordonnanceId;
    private int medicamentId;
    private int quantite;

    // Constructeurs
    public Posseder() {
    }

    public Posseder(int ordonnanceId, int medicamentId, int quantite) {
        this.ordonnanceId = ordonnanceId;
        this.medicamentId = medicamentId;
        this.quantite = quantite;
    }

    // Getters et Setters
    public int getOrdonnanceId() {
        return ordonnanceId;
    }

    public void setOrdonnanceId(int ordonnanceId) {
        this.ordonnanceId = ordonnanceId;
    }

    public int getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(int medicamentId) {
        this.medicamentId = medicamentId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Ordonnance ID : " + ordonnanceId + ", Médicament ID : " + medicamentId + ", Quantité : " + quantite;
    }
}

