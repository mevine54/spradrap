package fr.mevine.models;

import fr.mevine.enums.TypeMedicament;

public class Medicament {
    private int mediId;
    private String nom;
    private TypeMedicament typeMedicament;
    private double prix;
    private int stock;

    // Constructeurs
    public Medicament() {
    }

    public Medicament(int mediId, String nom, TypeMedicament typeMedicament, double prix, int stock) {
        this.mediId = mediId;
        this.nom = nom;
        this.typeMedicament = typeMedicament;
        this.prix = prix;
        this.stock = stock;
    }

    // Getters et Setters
    public int getMediId() {
        return mediId;
    }

    public void setMediId(int id) {
        this.mediId = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeMedicament getCategorie() {
        return typeMedicament;
    }

    public void setCategorie(TypeMedicament categorie) {
        this.typeMedicament = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nom + " (" + typeMedicament + "), Prix : " + prix + " €, Stock : " + stock;
    }
}

