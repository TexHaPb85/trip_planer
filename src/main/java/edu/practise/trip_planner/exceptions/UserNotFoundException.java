package edu.practise.trip_planner.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
