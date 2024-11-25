package fr.mevine.models;

public class Posseder {
    private Integer utiId; // Clé étrangère vers Utilisateur
    private Integer adrId; // Clé étrangère vers Adresse

    // Getters et setters
    public Integer getUtiId() {
        return utiId;
    }

    public void setUtiId(Integer utiId) {
        this.utiId = utiId;
    }

    public Integer getAdrId() {
        return adrId;
    }

    public void setAdrId(Integer adrId) {
        this.adrId = adrId;
    }
}
