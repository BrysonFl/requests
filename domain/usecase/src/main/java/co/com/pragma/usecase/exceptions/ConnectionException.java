package co.com.pragma.usecase.exceptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message) {
        super(message);
    }
}
