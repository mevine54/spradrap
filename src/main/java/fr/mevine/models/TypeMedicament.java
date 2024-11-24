package fr.mevine.models;

public class TypeMedicament {
    private Integer typeMedId;
    private String nom;

    // Constructeurs
    public TypeMedicament() {
    }

    public TypeMedicament(Integer typeMedId, String nom) {
        this.typeMedId = typeMedId;
        this.nom = nom;
    }

    // Getters et Setters
    public int getTypeMedId() {
        return typeMedId;
    }

    public void setTypeMedId(Integer medId) {
        this.typeMedId = medId;
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

