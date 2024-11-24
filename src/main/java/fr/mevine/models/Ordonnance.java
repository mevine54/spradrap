package fr.mevine.models;

import java.time.LocalDate;
import java.util.List;

public class Ordonnance {
    private Integer ordId;
    private LocalDate date; // Utilisation uniforme de LocalDate
    private Medecin medecin;
    private Client client;
    private List<Medicament> medicaments;

    // Constructeurs
    public Ordonnance() {
    }

    public Ordonnance(Integer ordId, LocalDate date, Medecin medecin, Client client, List<Medicament> medicaments) {
        this.ordId = ordId;
        this.date = date;
        this.medecin = medecin;
        this.client = client;
        this.medicaments = medicaments;
    }

    // Getters et Setters
    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
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

    @Override
    public String toString() {
        return "Ordonnance ID : " + ordId + ", Client : " + client + ", Médecin : " + medecin;
    }
}
