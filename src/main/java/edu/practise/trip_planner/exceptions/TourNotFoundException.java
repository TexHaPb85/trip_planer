package edu.practise.trip_planner.exceptions;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException() {
    }

    public TourNotFoundException(String message) {
        super(message);
    }
}
