package edu.aitu.oop3.services;

import edu.aitu.oop3.entities.*;
import edu.aitu.oop3.repositories.*;
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