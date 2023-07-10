package com.towerbuilder.proposalsubmitter.exception;

public class CurrentUserNotFoundException extends RuntimeException{
    public CurrentUserNotFoundException(String message) {
        super(message);
    }
}
