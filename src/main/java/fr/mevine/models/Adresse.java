package fr.mevine.models;

public class Adresse {
    private Integer adrId;
    private String rue;
    private String codePostal;
    private String ville;

    // Constructeurs
    public Adresse() {
    }

    public Adresse(Integer adrId, String rue, String codePostal, String ville) {
        this.adrId = adrId;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    // Getters et Setters
    public int getAdrId() {
        return adrId;
    }

    public void setAdrId(Integer adrId) {
        this.adrId = adrId;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return rue + ", " + codePostal + " " + ville;
    }
}

