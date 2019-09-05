package edu.practise.trip_planner.service.user;

import edu.practise.trip_planner.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);

    User updateUser(Long id, User user);
}
