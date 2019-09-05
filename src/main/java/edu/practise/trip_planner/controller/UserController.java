package edu.practise.trip_planner.controller;

import edu.practise.trip_planner.entities.User;
import edu.practise.trip_planner.service.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.saveUser(user));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }

    @GetMapping("/user")
    public ResponseEntity getAllUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User by id " + id + " deleted successfully");
    }

    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User " + userService.updateUser(id, user) + " updated successfully");
    }
}
