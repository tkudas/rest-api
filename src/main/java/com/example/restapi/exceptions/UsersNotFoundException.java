package com.example.restapi.exceptions;

public class UsersNotFoundException extends RuntimeException {

    public UsersNotFoundException() {
        super("Users Not Found");
    }
}
