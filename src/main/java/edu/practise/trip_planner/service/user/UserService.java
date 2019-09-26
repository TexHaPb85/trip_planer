package edu.practise.trip_planner.service.user;

import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.entities.User;

import java.util.List;

public interface UserService {
    User addTourToUser(Long userId, Tour tour);

    User addUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    void deleteUserById(Long id);

    User editUser(Long id, User user);
}
