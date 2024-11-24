package fr.mevine.models;

public class Mutuelle {
    private int id;
    private String nom;
    private Adresse adresse;
    private String telephone;
    private String email;
    private String departement;
    private double tauxPriseEnCharge;

    // Constructeurs
    public Mutuelle() {
    }

    public Mutuelle(int id, String nom, Adresse adresse, String telephone, String email, String departement, double tauxPriseEnCharge) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.departement = departement;
        this.tauxPriseEnCharge = tauxPriseEnCharge;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public double getTauxPriseEnCharge() {
        return tauxPriseEnCharge;
    }

    public void setTauxPriseEnCharge(double tauxPriseEnCharge) {
        this.tauxPriseEnCharge = tauxPriseEnCharge;
    }

    @Override
    public String toString() {
        return nom + " (" + tauxPriseEnCharge + "% prise en charge)";
    }
}
