package edu.hillel.streams;

public class NoAccessRightsException extends Exception {

    public NoAccessRightsException() {
    }

    public NoAccessRightsException(String message) {
        super(message);
    }

    public NoAccessRightsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAccessRightsException(Throwable cause) {
        super(cause);
    }

    public NoAccessRightsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
