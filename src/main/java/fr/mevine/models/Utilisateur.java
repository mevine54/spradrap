package fr.mevine.models;

public abstract class Utilisateur {
    private Integer utiId;
    private String utiNom;
    private String utiPrenom;
    private Adresse adresse;
    private String utiTel;
    private String utiEmail;

    // Constructeur vide (si nécessaire)
    public Utilisateur() {
    }

    // Constructeur complet
    public Utilisateur(Integer utiId, String utiNom, String utiPrenom, Adresse adresse, String utiTel, String utiEmail) {
        this.utiId = utiId;
        this.utiNom = utiNom;
        this.utiPrenom = utiPrenom;
        this.adresse = adresse;
        this.utiTel = utiTel;
        this.utiEmail = utiEmail;
    }

    // Getters et Setters
    public Integer getUtiId() {
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

    public String getUtiPrenom() {
        return utiPrenom;
    }

    public void setUtiPrenom(String utiPrenom) {
        this.utiPrenom = utiPrenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getUtiTel() {
        return utiTel;
    }

    public void setUtiTel(String utiTel) {
        this.utiTel = utiTel;
    }

    public String getUtiEmail() {
        return utiEmail;
    }

    public void setUtiEmail(String utiEmail) {
        this.utiEmail = utiEmail;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + utiId +
                ", nom='" + utiNom + '\'' +
                ", prenom='" + utiPrenom + '\'' +
                ", adresse=" + adresse +
                ", telephone='" + utiTel + '\'' +
                ", email='" + utiEmail + '\'' +
                '}';
    }
}
