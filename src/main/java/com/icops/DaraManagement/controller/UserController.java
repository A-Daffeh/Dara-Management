package com.icops.DaraManagement.controller;

import com.icops.DaraManagement.model.User;
import com.icops.DaraManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User newUser = userService.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
