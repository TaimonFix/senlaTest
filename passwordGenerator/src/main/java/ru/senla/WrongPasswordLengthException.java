package ru.senla;

public class WrongPasswordLengthException extends RuntimeException {
    public WrongPasswordLengthException() {
    }

    public WrongPasswordLengthException(String message) {
        super(message);
    }
}
