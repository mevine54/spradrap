package fr.mevine.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OrdonnanceView extends JFrame {
    public OrdonnanceView() {
        setTitle("Pharmacie Sparadrap - Gestion des Ordonnances");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        JLabel lblOrdonnance = new JLabel("Sélectionner une ordonnance:");
        lblOrdonnance.setBounds(50, 50, 200, 30);
        add(lblOrdonnance);

        JComboBox<String> cbOrdonnances = new JComboBox<>(new String[]{"Ordonnance #1", "Ordonnance #2"});
        cbOrdonnances.setBounds(300, 50, 200, 30);
        add(cbOrdonnances);

        JButton btnAfficher = new JButton("Afficher les détails");
        btnAfficher.setBounds(520, 50, 150, 30);
        btnAfficher.addActionListener(e -> {
            // Exemple : Ajouter une action pour afficher les détails d'une ordonnance
            JOptionPane.showMessageDialog(this, "Détails de l'ordonnance sélectionnée");
        });
        add(btnAfficher);

        JTable tableMedicaments = new JTable(new DefaultTableModel(
                new String[]{"Médicament", "Quantité", "Prix Unitaire"}, 0
        ));
        JScrollPane scrollPane = new JScrollPane(tableMedicaments);
        scrollPane.setBounds(50, 100, 700, 300);
        add(scrollPane);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 500, 100, 30);
        btnRetour.addActionListener(e -> {
            new DashboardView().setVisible(true);
            dispose();
        });
        add(btnRetour);

        JButton btnAjouter = new JButton("Ajouter une ordonnance");
        btnAjouter.setBounds(200, 500, 200, 30);
        btnAjouter.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Ajouter une nouvelle ordonnance - À implémenter");
        });
        add(btnAjouter);
    }
}

