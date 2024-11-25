package fr.mevine.views;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DashboardView extends JFrame {
    public DashboardView() {
        setTitle("Pharmacie Sparadrap - Dashboard");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);

        JButton btnAchat = new JButton("Effectuer un achat");
        btnAchat.setBounds(50, 50, 200, 50);
        btnAchat.addActionListener((ActionEvent e) -> {
            new AchatView().setVisible(true);
            dispose();
        });

        JButton btnHistorique = new JButton("Consulter l'historique des achats");
        btnHistorique.setBounds(50, 120, 200, 50);
        btnHistorique.addActionListener((ActionEvent e) -> {
            new HistoriqueView().setVisible(true);
            dispose();
        });

        JButton btnMedecin = new JButton("Consulter un médecin / spécialiste");
        btnMedecin.setBounds(50, 190, 200, 50);
        btnMedecin.addActionListener((ActionEvent e) -> {
            new MedecinView().setVisible(true);
            dispose();
        });

        JButton btnClient = new JButton("Consulter un client");
        btnClient.setBounds(50, 260, 200, 50);
        btnClient.addActionListener((ActionEvent e) -> {
            new ClientView().setVisible(true);
            dispose();
        });

        JButton btnQuit = new JButton("Quitter l'application");
        btnQuit.setBounds(50, 330, 200, 50);
        btnQuit.addActionListener((ActionEvent e) -> System.exit(0));

        add(btnAchat);
        add(btnHistorique);
        add(btnMedecin);
        add(btnClient);
        add(btnQuit);
    }

    public static void main(String[] args) {
        new DashboardView1().setVisible(true);
    }
}
