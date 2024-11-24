package fr.mevine.models;

public class Mutuelle {
    private Integer mutId;
    private String mutNom;
    private Adresse adresse;
    private String mutTel;
    private String mutEmail;
    private String mutDepartement;
    private double mutTauxPriseEnCharge;

    // Constructeurs
    public Mutuelle() {
    }

    public Mutuelle(Integer mutId, String mutNom, Adresse adresse, String mutTel, String mutEmail, String mutDepartement, double mutTauxPriseEnCharge) {
        this.mutId = mutId;
        this.mutNom = mutNom;
        this.adresse = adresse;
        this.mutTel = mutTel;
        this.mutEmail = mutEmail;
        this.mutDepartement = mutDepartement;
        this.mutTauxPriseEnCharge = mutTauxPriseEnCharge;
    }

    // Getters et Setters
    public int getMutId() {
        return mutId;
    }

    public void setMutId(Integer mutId) {
        this.mutId = mutId;
    }

    public String getMutNom() {
        return mutNom;
    }

    public void setMutNom(String mutNom) {
        this.mutNom = mutNom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getMutTel() {
        return mutTel;
    }

    public void setMutTel(String mutTel) {
        this.mutTel = mutTel;
    }

    public String getMutEmail() {
        return mutEmail;
    }

    public void setMutEmail(String mutEmail) {
        this.mutEmail = mutEmail;
    }

    public String getMutDepartement() {
        return mutDepartement;
    }

    public void setMutDepartement(String mutDepartement) {
        this.mutDepartement = mutDepartement;
    }

    public double getMutTauxPriseEnCharge() {
        return mutTauxPriseEnCharge;
    }

    public void setMutTauxPriseEnCharge(double mutTauxPriseEnCharge) {
        this.mutTauxPriseEnCharge = mutTauxPriseEnCharge;
    }

    @Override
    public String toString() {
        return mutNom + " (" + mutTauxPriseEnCharge + "% prise en charge)";
    }
}
