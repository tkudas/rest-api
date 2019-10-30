package com.example.restapi.exeptions;

public class UsersNotFoundExeption extends RuntimeException {

    public UsersNotFoundExeption() {
        super("Users Not Found");
    }
}
