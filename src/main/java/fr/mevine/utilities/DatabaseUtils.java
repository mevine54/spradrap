package fr.mevine.utilities;

import fr.mevine.exceptions.SystemeException;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtils {

    // Commencer une transaction
    public static void beginTransaction(Connection connection) {
        try {
            if (connection != null && !connection.getAutoCommit()) {
                throw new SystemeException("Une transaction est déjà en cours.");
            }
            if (connection != null) {
                connection.setAutoCommit(false);
            }
        } catch (SQLException e) {
            throw new SystemeException("Erreur lors du démarrage de la transaction.", e);
        }
    }

    // Valider une transaction
    public static void commitTransaction(Connection connection) {
        try {
            if (connection != null) {
                connection.commit();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new SystemeException("Erreur lors de la validation de la transaction.", e);
        }
    }

    // Annuler une transaction
    public static void rollbackTransaction(Connection connection) {
        try {
            if (connection != null) {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new SystemeException("Erreur lors de l'annulation de la transaction.", e);
        }
    }

    // Fermer une connexion
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new SystemeException("Erreur lors de la fermeture de la connexion.", e);
        }
    }
}

