package edu.hillel.streams;

public class FileIsDirectoryException extends Exception{

    public FileIsDirectoryException() {
    }

    public FileIsDirectoryException(String message) {
        super(message);
    }

    public FileIsDirectoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIsDirectoryException(Throwable cause) {
        super(cause);
    }

    public FileIsDirectoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
