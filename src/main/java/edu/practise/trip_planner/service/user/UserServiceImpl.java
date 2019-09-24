package edu.practise.trip_planner.service.user;


import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.entities.User;
import edu.practise.trip_planner.exceptions.UserNotFoundException;
import edu.practise.trip_planner.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addTourToUser(Long userId, Tour tour) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException("The user with id " + userId + " doesn't found"));
        user.addTour(tour);

        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("The user with id " + id + " doesn't found"));
    }

    public Optional<User> findById(Long id){
        return  userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User editUser(Long id, User user) {
        User existedUser = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("The user with id " + id + " doesn't found"));

        existedUser.setName(user.getName());
        existedUser.setEmail(user.getEmail());

        return userRepository.save(existedUser);
    }
}
