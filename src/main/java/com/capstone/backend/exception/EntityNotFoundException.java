package com.capstone.backend.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
        super("No record of " + entity.getSimpleName().toLowerCase() + " with id '" + id);

    }

    public EntityNotFoundException(String username, Class<?> entity) {
        super("No record of " + entity.getSimpleName().toLowerCase() + " with username '" + username);
    }

}