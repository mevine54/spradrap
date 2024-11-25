package fr.mevine.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    // Constructeur privé pour empêcher l'instanciation
    private DatabaseConnection() {}

    /**
     * Méthode pour obtenir une connexion unique (Singleton).
     *
     * @return Connection - Instance de connexion unique.
     * @throws SQLException Si une erreur survient lors de la connexion.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Charger le fichier de configuration via ConfigUtils
                String url = ConfigUtils.getProperty("db.url");
                String user = ConfigUtils.getProperty("db.user");
                String password = ConfigUtils.getProperty("db.password");
                String driver = ConfigUtils.getProperty("db.driver");

                // Charger le driver JDBC
                Class.forName(driver);

                // Créer la connexion
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connexion réussie à la base de données !");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException("Driver JDBC introuvable : " + e.getMessage());
            }
        }
        return connection;
    }

    /**
     * Méthode pour fermer la connexion manuellement (optionnel).
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}

