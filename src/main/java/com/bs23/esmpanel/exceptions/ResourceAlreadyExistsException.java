package com.bs23.esmpanel.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException() {
        super();
    }

    public ResourceAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
