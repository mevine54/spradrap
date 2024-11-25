package fr.mevine.models;

public class Adresse {
    private Integer adrId;
    private String adrRue;
    private String adrCodePostal;
    private String adrVille;

    // Constructeurs
    public Adresse() {
    }

    public Adresse(Integer adrId, String adrRue, String adrCodePostal, String adrVille) {
        this.adrId = adrId;
        this.adrRue = adrRue;
        this.adrCodePostal = adrCodePostal;
        this.adrVille = adrVille;
    }

    // Getters et Setters
    public Integer getAdrId() {
        return adrId;
    }

    public void setAdrId(Integer adrId) {
        this.adrId = adrId;
    }

    public String getAdrRue() {
        return adrRue;
    }

    public void setAdrRue(String adrRue) {
        this.adrRue = adrRue;
    }

    public String getAdrCodePostal() {
        return adrCodePostal;
    }

    public void setAdrCodePostal(String adrCodePostal) {
        this.adrCodePostal = adrCodePostal;
    }

    public String getAdrVille() {
        return adrVille;
    }

    public void setAdrVille(String adrVille) {
        this.adrVille = adrVille;
    }

    @Override
    public String toString() {
        return adrRue + ", " + adrCodePostal + " " + adrVille;
    }
}

