package edu.aitu.oop3.components.Project.services;

import edu.aitu.oop3.components.Project.entities.User;
import edu.aitu.oop3.components.Project.repositories.UserRepository;

import java.sql.SQLException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws SQLException {
        userRepository.save(user);
    }
}