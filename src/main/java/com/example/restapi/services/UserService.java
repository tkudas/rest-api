package com.example.restapi.services;

import com.example.restapi.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User addUser(User user);
}
