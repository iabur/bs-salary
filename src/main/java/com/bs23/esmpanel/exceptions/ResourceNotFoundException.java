package com.bs23.esmpanel.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
