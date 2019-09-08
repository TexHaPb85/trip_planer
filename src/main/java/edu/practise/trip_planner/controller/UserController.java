package edu.practise.trip_planner.controller;

import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.entities.User;
import edu.practise.trip_planner.service.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User by id " + id + " deleted successfully");
    }

    @PutMapping("{id}")
    public ResponseEntity editUser(@PathVariable("id") Long id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User " + userService.editUser(id, user) + " updated successfully");
    }

    @PatchMapping("{id}/addTour")
    public ResponseEntity addTourToUser(@PathVariable("id") Long id, @RequestBody Tour tour) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.addTourToUser(id, tour));
    }
}
