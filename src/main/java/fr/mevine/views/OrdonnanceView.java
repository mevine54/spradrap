package fr.mevine.views;

import fr.mevine.models.Medicament;
import fr.mevine.models.Ordonnance;

import java.util.List;

public class OrdonnanceView {

    // Afficher les détails d'une ordonnance
    public void afficherOrdonnance(Ordonnance ordonnance) {
        System.out.println("Date de l'ordonnance : " + ordonnance.getDate());
        System.out.println("Médecin : " + ordonnance.getMedecin().getMedNom());
        System.out.println("Patient : " + ordonnance.getClient().getUtiNom());
        System.out.println("Liste des médicaments : ");
        for (Medicament medicament : ordonnance.getMedicaments()) {
            System.out.println(" - " + medicament.getNom() + " (Quantité: " + medicament.getStock() + ", Catégorie: " + medicament.getCategorie() + ")");
        }
        if (ordonnance.getSpecialiste() != null) {
            System.out.println("Spécialiste : " + ordonnance.getSpecialiste().getNom() + " (" + ordonnance.getSpecialiste().getSpecialite() + ")");
        }
    }

    // Afficher une liste d'ordonnances
    public void afficherListeOrdonnances(List<Ordonnance> ordonnances) {
        for (Ordonnance ordonnance : ordonnances) {
            afficherOrdonnance(ordonnance);
            System.out.println("--------------------");
        }
    }
}
