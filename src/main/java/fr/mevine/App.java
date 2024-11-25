package fr.mevine;


import fr.mevine.dao.ClientDao;
import fr.mevine.views.DashboardView;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import javax.swing.*;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello SQL!");

        // Créer une instance de la classe App
        App app = new App();


        ClientDao clientDAO = new ClientDao();
        clientDAO.getAll();
        clientDAO.getById(1);

        // *** Affichage de l'interface graphique (Swing) ***
        SwingUtilities.invokeLater(() -> {
            new DashboardView(); // Affiche l'interface graphique Swing
        });

    }

}




