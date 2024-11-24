package fr.mevine.models;

import fr.mevine.enums.TypeMedicament;

public class Medicament {
    private Integer mediId;
    private String mediNom;
    private TypeMedicament typeMedicament;
    private double mediPrix;
    private int stock;

    // Constructeurs
    public Medicament() {
    }

    public Medicament(Integer mediId, String mediNom, TypeMedicament typeMedicament, double mediPrix, int stock) {
        this.mediId = mediId;
        this.mediNom = mediNom;
        this.typeMedicament = typeMedicament;
        this.mediPrix = mediPrix;
        this.stock = stock;
    }

    // Getters et Setters
    public int getMediId() {
        return mediId;
    }

    public void setMediId(int id) {
        this.mediId = id;
    }

    public String getMediNom() {
        return mediNom;
    }

    public void setMediNom(String mediNom) {
        this.mediNom = mediNom;
    }

    public TypeMedicament getTypeMedicament() {
        return typeMedicament;
    }

    public void setCategorie(TypeMedicament categorie) {
        this.typeMedicament = categorie;
    }

    public double getMediPrix() {
        return mediPrix;
    }

    public void setMediPrix(double mediPrix) {
        this.mediPrix = mediPrix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return mediNom + " (" + typeMedicament + "), Prix : " + mediPrix + " €, Stock : " + stock;
    }
}

