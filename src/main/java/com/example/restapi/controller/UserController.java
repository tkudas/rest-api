package com.example.restapi.controller;

import com.example.restapi.domain.User;
import com.example.restapi.domain.UserExt;
import com.example.restapi.exceptions.UsersNotFoundException;
import com.example.restapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.findAllUser();
        if (userList.isEmpty()) throw new UsersNotFoundException();
        return ResponseEntity.ok(userExtendedToBirthsday(userList));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    private List<UserExt> userExtendedToBirthsday(List<User> userList) {
        List<UserExt> userListExt = new ArrayList<>();
        for (User user : userList) {
            UserExt userExt = new UserExt();
            userExt.setFirstname(user.getFirstname());
            userExt.setLastname((user.getLastname()));
            userExt.setPesel(user.getPesel());
            userExt.setBirthdate(convertPeselToData(user.getPesel()));
            userListExt.add(userExt);
        }
        ;
        return userListExt;
    }

    private String convertPeselToData(String pesel) {
        String prefix;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pesel);
        if (Integer.parseInt(stringBuilder.substring(2, 4)) < 13) {
            prefix = "19";
        } else if (Integer.parseInt(stringBuilder.substring(2, 4)) > 79) {
            prefix = "18";
        } else {
            prefix = "20";
        }
        return (prefix +
                stringBuilder.substring(0, 2) + "-" +
                stringBuilder.substring(2, 4) + "-" +
                stringBuilder.substring(4, 6)
        );
    }
}

