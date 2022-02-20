package com.example.restservice.exception;

public class PeopleNotFoundException extends RuntimeException {
    private String message;
    public PeopleNotFoundException(String message){
        super(message);
        this.message = message;
    }
    public PeopleNotFoundException(){}
}
