package fr.mevine.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties properties = new Properties();

    // Bloc statique pour charger les propriétés dès le chargement de la classe
    static {
        try (InputStream input = ConfigUtils.class.getClassLoader().getResourceAsStream("conf.properties")) {
            if (input == null) {
                throw new IOException("Fichier conf.properties introuvable dans resources.");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors du chargement du fichier conf.properties : " + e.getMessage());
        }
    }

    /**
     * Récupère la valeur d'une propriété à partir du fichier conf.properties.
     *
     * @param key Clé de la propriété.
     * @return Valeur associée à la clé.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

