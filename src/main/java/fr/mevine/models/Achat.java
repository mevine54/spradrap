package fr.mevine.models;

import java.time.LocalDate;

public class Achat {
    private Integer achatId;          // ID de l'achat
    private LocalDate dateAchat;      // Date de l'achat
    private Client client;            // Client ayant effectué l'achat
    private Medicament medicament;    // Médicament acheté
    private Integer quantite;         // Quantité achetée
    private Double prixTotal;         // Prix total de l'achat
    private Ordonnance ordonnance;    // Ordonnance associée (si applicable)

    // Constructeurs
    public Achat() {
    }

    public Achat(Integer achatId, LocalDate dateAchat, Client client, Medicament medicament, Integer quantite, Double prixTotal, Ordonnance ordonnance) {
        this.achatId = achatId;
        this.dateAchat = dateAchat;
        this.client = client;
        this.medicament = medicament;
        this.quantite = quantite;
        this.prixTotal = prixTotal;
        this.ordonnance = ordonnance;
    }

    // Getters et Setters
    public Integer getAchatId() {
        return achatId;
    }

    public void setAchatId(Integer achatId) {
        this.achatId = achatId;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    // Méthode pour calculer automatiquement le prix total
    public void calculerPrixTotal() {
        if (medicament != null && quantite != null) {
            this.prixTotal = medicament.getMediPrix() * quantite;
        }
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Achat{" +
                "achatId=" + achatId +
                ", dateAchat=" + dateAchat +
                ", client=" + (client != null ? client.getCliId() : "N/A") +
                ", medicament=" + (medicament != null ? medicament.getMediNom() : "N/A") +
                ", quantite=" + quantite +
                ", prixTotal=" + prixTotal +
                ", ordonnance=" + (ordonnance != null ? ordonnance.getOrdId() : "N/A") +
                '}';
    }
}
