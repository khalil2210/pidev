package com.group3.camping_project.service.user_management.exception;
    public class EmailAlreadyExistsException extends RuntimeException {

        public EmailAlreadyExistsException(String email) {
            super("Email " + email + "already exists");
        }

    }

