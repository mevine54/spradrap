package fr.mevine.models;

import fr.mevine.enums.TypeSpecialite;

public class Specialiste extends Utilisateur {
    private TypeSpecialite typeSpecialite;

    // Constructeurs
    public Specialiste() {
    }

    public Specialiste(Integer speId, String nom, String prenom, String telephone, String email, Adresse adresse,
                       TypeSpecialite typeSpecialite) {
        super(speId, nom, prenom, adresse, telephone, email);
        this.typeSpecialite = typeSpecialite;
    }

    // Getters et Setters
    public TypeSpecialite getTypeSpecialite() {
        return typeSpecialite;
    }

    public void setSpecialite(TypeSpecialite typeSpecialite) {
        this.typeSpecialite = typeSpecialite;
    }

    @Override
    public String toString() {
        return super.toString() + ", Spécialité : " + typeSpecialite;
    }
}

