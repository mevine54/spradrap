package fr.mevine.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Singleton {

    private static final Properties props = new Properties();
    private static Connection connection;
    private static final String PATHCONF = "conf.properties";

    private Singleton() {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(PATHCONF)) {
            if (is == null) {
                throw new RuntimeException("Fichier de configuration non trouvé : " + PATHCONF);
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Class.forName(props.getProperty("db.driver"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie avec succès à la base de données.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getInstanceDB() {
        if (connection == null) {
            new Singleton();
            System.out.println("RelationWithDB infos : Connection established");
        } else {
            System.out.println("RelationWithDB infos : Connection already existing");
        }
        return getConnection();
    }

    public static void closeInstanceDB() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("RelationWithDB infos : Connection terminated");
            }
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
