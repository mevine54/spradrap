package fr.mevine.models;

public class TypeSpecialite {
    private Integer typeSpeId;
    private String nom;

    // Constructeurs
    public TypeSpecialite() {
    }

    public TypeSpecialite(Integer typeSpeId, String nom) {
        this.typeSpeId = typeSpeId;
        this.nom = nom;
    }

    // Getters et Setters
    public int getTypeSpeId() {
        return typeSpeId;
    }

    public void setTypeSpeId(Integer typeSpeId) {
        this.typeSpeId = typeSpeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}

