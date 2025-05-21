package com.megadev.hr.exception;

public class PhoneNumberIsNotAvailableException extends RuntimeException{
    public PhoneNumberIsNotAvailableException(String message) {
        super(message);
    }
}
