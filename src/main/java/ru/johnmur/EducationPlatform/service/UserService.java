package ru.johnmur.EducationPlatform.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.johnmur.EducationPlatform.model.User;
import ru.johnmur.EducationPlatform.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(long id) {
        logger.info("[SERVICE METHOD] Get user by id: " + id);
        return userRepository.findById(id)
                .map(user -> {
                    logger.info("User found with id " + user.getId());
                    return user;
                })
                .or(() -> {
                    logger.warn("User with id " + id + " not found");
                    return Optional.empty();
                });
    }

    public Optional<User> getUserByUsername(String username) {
        logger.info("[SERVICE METHOD] Get user by username: " + username);
        return userRepository.findByUsername(username)
                .map(user -> {
                    logger.info("User found with name " + user.getUsername());
                    return user;
                })
                .or(() -> {
                    logger.warn("User with name " + username + " not found");
                    return Optional.empty();
                });
    }

    public Optional<User> deleteUserById(Long id) {
        logger.info("[SERVICE METHOD] Delete user by id: " + id);
        return userRepository.findById(id)
                .map(user -> {
                    logger.info("User found with id " + user.getId());
                    userRepository.delete(user);
                    logger.info("User with id " + user.getId() + " deleted successfully");
                    return user;
                })
                .or(() -> {
                    logger.warn("User with id " + id + " not found");
                    return Optional.empty();
                });
    }

    public Optional<User> createUser(User user) {
        logger.info("[SERVICE METHOD] Create user: " + user);
        try {
            userRepository.save(user);
            logger.info("User with id " + user.getId() + " created successfully");
            return Optional.of(user);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            return Optional.empty();
        }
    }

    public Optional<List<User>> getAllUsers() {
        logger.info("[SERVICE METHOD] Get all users");

        return Optional.of(userRepository.findAll());
    }
}
