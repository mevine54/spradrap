package fr.mevine.views;

import javax.swing.*;

public class AchatView extends JFrame {
    public AchatView() {
        setTitle("Pharmacie Sparadrap - Achat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        JLabel lblTypeAchat = new JLabel("Sélectionner le type d'achat:");
        lblTypeAchat.setBounds(50, 50, 200, 30);
        add(lblTypeAchat);

        JComboBox<String> cbTypeAchat = new JComboBox<>(new String[]{"Achat direct", "Achat via ordonnance"});
        cbTypeAchat.setBounds(300, 50, 200, 30);
        add(cbTypeAchat);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 500, 100, 30);
        btnRetour.addActionListener(e -> {
            new DashboardView1().setVisible(true);
            dispose();
        });
        add(btnRetour);

        JButton btnValider = new JButton("Valider l'achat");
        btnValider.setBounds(200, 500, 150, 30);
        add(btnValider);
    }
}

