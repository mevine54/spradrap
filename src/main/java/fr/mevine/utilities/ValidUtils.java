package fr.mevine.utilities;

import java.util.regex.Pattern;

public class ValidUtils {

    // Valider une adresse e-mail
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }

    // Valider un numéro de sécurité sociale (15 chiffres)
    public static boolean isValidNumSecuSocial(String numSecuSocial) {
        return numSecuSocial != null && numSecuSocial.matches("\\d{15}");
    }

    // Valider un numéro de téléphone (10 chiffres)
    public static boolean isValidTelephone(String telephone) {
        return telephone != null && telephone.matches("\\d{10}");
    }

    // Valider une chaîne non vide
    public static boolean isNonEmptyString(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Valider une chaîne avec une longueur maximale
    public static boolean isValidLength(String str, int maxLength) {
        return str != null && str.length() <= maxLength;
    }
}
