package ru.dorofeev.sberbankproject.exception.page;

public class NoSuchPageException extends RuntimeException {
    public NoSuchPageException(String message) {
        super(message);
    }
}
