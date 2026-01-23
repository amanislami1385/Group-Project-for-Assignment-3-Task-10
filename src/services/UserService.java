package services;

import entities.User;
import repositories.UserRepository;
import java.sql.SQLException;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws SQLException {
        userRepository.save(user);
    }
}dd