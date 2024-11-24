package fr.mevine.models;

import java.time.LocalDate;
import java.util.List;

public class Ordonnance {
    private Integer ordId; // Nom aligné avec la BDD
    private LocalDate date;
    private Medecin medecin;
    private Client client;
    private Specialiste specialiste;
    private List<Medicament> medicaments;

    // Constructeurs
    public Ordonnance() {
    }

    public Ordonnance(Integer ordId, LocalDate date, Medecin medecin, Client client, Specialiste specialiste) {
        this.ordId = ordId;
        this.date = date;
        this.medecin = medecin;
        this.client = client;
        this.specialiste = specialiste;
    }

    // Getters et Setters
    public Integer getOrdId() {
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

    public Specialiste getSpecialiste() {
        return specialiste;
    }

    public void setSpecialiste(Specialiste specialiste) {
        this.specialiste = specialiste;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }

    @Override
    public String toString() {
        return "Ordonnance ID : " + ordId +
                ", Date : " + date +
                ", Médecin : " + (medecin != null ? medecin.getUtiNom() : "N/A") +
                ", Client : " + (client != null ? client.getUtiNom() : "N/A") +
                ", Spécialiste : " + (specialiste != null ? specialiste.getTypeSpecialite() : "N/A");
    }
}
