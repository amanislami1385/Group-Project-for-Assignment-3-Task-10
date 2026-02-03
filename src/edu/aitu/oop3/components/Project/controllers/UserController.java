package edu.aitu.oop3.components.Project.controllers;

import edu.aitu.oop3.components.Project.entities.User;
import edu.aitu.oop3.components.Project.services.UserService;

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