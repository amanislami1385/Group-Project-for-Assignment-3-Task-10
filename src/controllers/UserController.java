package controllers;

import entities.User;
import services.UserService;

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