package com.hpg.service.payments.exception;

public class CreateUserException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    public CreateUserException(String message) {
        super(message);
    }

    public CreateUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateUserException(Throwable cause) {
        super(cause);
    }
}
