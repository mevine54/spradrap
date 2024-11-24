package fr.mevine.models;

public abstract class Utilisateur {
    private Integer utiId;
    private String utiNom;
    private String prenom;
    private Adresse adresse;
    private String telephone;
    private String email;

    // Constructeur vide (si nécessaire)
    public Utilisateur() {
    }

    // Constructeur complet
    public Utilisateur(Integer utiId, String utiNom, String prenom, Adresse adresse, String telephone, String email) {
        this.utiId = utiId;
        this.utiNom = utiNom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    // Getters et Setters
    public int getUtiId() {
        return utiId;
    }

    public void setUtiId(Integer utiId) {
        this.utiId = utiId;
    }

    public String getUtiNom() {
        return utiNom;
    }

    public void setUtiNom(String utiNom) {
        this.utiNom = utiNom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + utiId +
                ", nom='" + utiNom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse=" + adresse +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
