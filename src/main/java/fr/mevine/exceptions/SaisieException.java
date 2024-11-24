package fr.mevine.exceptions;

public class SaisieException extends RuntimeException {
    public SaisieException(String message) {
        super(message);
    }

    public SaisieException(String message, Throwable cause) {
        super(message, cause);
    }
}

