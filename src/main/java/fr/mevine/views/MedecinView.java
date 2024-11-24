package fr.mevine.views;

import javax.swing.*;

public class MedecinView extends JFrame {
    public MedecinView() {
        setTitle("Pharmacie Sparadrap - Gestion des médecins");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        JLabel lblMedecin = new JLabel("Sélectionner un médecin:");
        lblMedecin.setBounds(50, 50, 200, 30);
        add(lblMedecin);

        JComboBox<String> cbMedecins = new JComboBox<>(new String[]{"Dr Jean Dupont", "Dr Marie Curie"});
        cbMedecins.setBounds(300, 50, 200, 30);
        add(cbMedecins);

        JButton btnRetour = new JButton("Retour");
        btnRetour.setBounds(50, 500, 100, 30);
        btnRetour.addActionListener(e -> {
            new DashboardView1().setVisible(true);
            dispose();
        });
        add(btnRetour);
    }
}

