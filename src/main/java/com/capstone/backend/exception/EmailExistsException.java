package com.capstone.backend.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class EmailExistsException extends SQLIntegrityConstraintViolationException {

    public EmailExistsException(String email) {
        super("The email is already in use");
    }
}
