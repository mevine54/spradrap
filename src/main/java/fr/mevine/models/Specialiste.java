package fr.mevine.models;

import fr.mevine.enums.TypeSpecialite;

public class Specialiste extends Medecin {
    Integer speId;
    private TypeSpecialite typeSpecialite;

    // Constructeurs
    public Specialiste() {
    }

    public Specialiste(Integer speId, String nom, String prenom, Adresse adresse, String telephone, String email, String numeroAgrement, TypeSpecialite typeSpecialite) {
        super(speId, nom, prenom, telephone, email, adresse, numeroAgrement);
        this.typeSpecialite = typeSpecialite;
    }

    // Getters et Setters

    public Integer getSpeId() {
        return speId;
    }

    public void setSpeId(Integer speId) {
        this.speId = speId;
    }

    public TypeSpecialite getTypeSpecialite() {
        return typeSpecialite;
    }

    public void setTypeSpecialite(TypeSpecialite typeSpecialite) {
        this.typeSpecialite = typeSpecialite;
    }

    @Override
    public String toString() {
        return super.toString() + ", Spécialité : " + typeSpecialite;
    }
}
