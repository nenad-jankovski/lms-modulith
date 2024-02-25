package com.jnenad.lms.commons.exceptions;

public class ResourceAlreadyExistsException extends IllegalStateException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
