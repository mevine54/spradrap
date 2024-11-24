package fr.mevine.models;

import java.util.Date;
import java.util.List;

public class Achat {
    private int id;
    private Client client;
    private List<Medicament> medicaments;
    private double totalPrix;
    private Date date;

    // Constructeurs
    public Achat() {
    }

    public Achat(int id, Client client, List<Medicament> medicaments, double totalPrix, Date date) {
        this.id = id;
        this.client = client;
        this.medicaments = medicaments;
        this.totalPrix = totalPrix;
        this.date = date;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    public double getTotalPrix() {
        return totalPrix;
    }

    public void setTotalPrix(double totalPrix) {
        this.totalPrix = totalPrix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Achat ID : " + id + ", Client : " + client + ", Total : " + totalPrix + " €, Date : " + date;
    }
}

