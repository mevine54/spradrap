package fr.mevine.exceptions;

public class SystemeException extends RuntimeException {
    public SystemeException(String message) {
        super(message);
    }

    public SystemeException(String message, Throwable cause) {
        super(message, cause);
    }
}

