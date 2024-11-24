package fr.mevine.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HistoriqueView extends JFrame {
    public HistoriqueView() {
        setTitle("Pharmacie Sparadrap - Historique des achats");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        String[] columnNames = {"Date", "Client", "Médicament", "Quantité", "Prix total", "Médecin"};
        JTable table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 700, 400);
        add(scrollPane);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 500, 100, 30);
        btnRetour.addActionListener(e -> {
            new DashboardView1().setVisible(true);
            dispose();
        });
        add(btnRetour);
    }
}

