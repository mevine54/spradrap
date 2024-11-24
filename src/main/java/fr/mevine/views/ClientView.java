package fr.mevine.views;

import javax.swing.*;

public class ClientView extends JFrame {
    public ClientView() {
        setTitle("Pharmacie Sparadrap - Gestion des clients");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        JLabel lblClient = new JLabel("Sélectionner un client:");
        lblClient.setBounds(50, 50, 200, 30);
        add(lblClient);

        JComboBox<String> cbClients = new JComboBox<>(new String[]{"Pierre Martin", "Marie Dupont"});
        cbClients.setBounds(300, 50, 200, 30);
        add(cbClients);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 500, 100, 30);
        btnRetour.addActionListener(e -> {
            new DashboardView1().setVisible(true);
            dispose();
        });
        add(btnRetour);
    }
}

