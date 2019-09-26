package edu.practise.trip_planner.exceptions;

public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException() {
    }

    public PlaceNotFoundException(String message) {
        super(message);
    }
}
