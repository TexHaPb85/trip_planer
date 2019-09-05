package edu.practise.trip_planner.controller;


import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.service.tour.TourServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TourController {
    private final TourServiceImpl tourService;

    public TourController(TourServiceImpl tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/{id}/tour")
    @ResponseBody
    public ResponseEntity addTrip(@PathVariable("id") Long id, @RequestBody Tour tour) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.addTour(id, tour));
    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity deleteTripById(@PathVariable("id") Long id) {
        tourService.deleteTourById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Tour by id " + id + " deleted successfully");
    }

    @PutMapping("/{userId}/trip/{tripId}")
    @ResponseBody
    public ResponseEntity editTripById(@PathVariable("userId") Long userId, @PathVariable("tripId") Long tripId, @RequestBody Tour tour) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.editTourById(userId, tripId, tour));
    }

    @PatchMapping("/{userId}/trip/{tripId}")
    public ResponseEntity shareTripWhitOtherUser(@PathVariable("userId") Long userId, @PathVariable("tripId") Long tripId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.shareTourWithOtherUser(tripId,userId));
    }

    @GetMapping("/trip/{id}")
    public ResponseEntity<Tour> findTripById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.findTourById(id));
    }

    @GetMapping("/trip")
    public ResponseEntity showAllTrip(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.findAllTours());
    }
}
