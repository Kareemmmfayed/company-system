package com.megadev.hr.exception;

public class EmailIsNotAvailableException extends RuntimeException{
    public EmailIsNotAvailableException(String message) {
        super(message);
    }
}
