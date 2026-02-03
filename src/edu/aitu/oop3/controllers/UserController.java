package edu.aitu.oop3.controllers;

import edu.aitu.oop3.entities.User;
import edu.aitu.oop3.services.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        try {
            userService.createUser(user);
            System.out.println("User created successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}