package edu.practise.trip_planner.controller;


import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.entities.TourPlace;
import edu.practise.trip_planner.entities.User;
import edu.practise.trip_planner.service.tour.TourServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tours")
public class TourController {
    private final TourServiceImpl tourService;

    public TourController(TourServiceImpl tourService) {
        this.tourService = tourService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Tour> findTourById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.findTourById(id));
    }

    @GetMapping
    public ResponseEntity findAllTours() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.findAllTours());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity addTour(@RequestBody Tour tour) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.addTour(tour));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTourById(@PathVariable("id") Long id) {
        tourService.deleteTourById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Tour by id " + id + " deleted successfully");
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity editTourById(@PathVariable("id") Long id, @RequestBody Tour tour) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.editTourById(id, tour));
    }

    @PatchMapping("{tourId}/userRegistration")
    public ResponseEntity addUserToTour(@PathVariable("tourId") Long tourId, @RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.addUserToTour(tourId,user));
    }

    @PatchMapping("{tourId}/placeRegistration")
    public ResponseEntity addPlaceToTour(@PathVariable("tourId") Long tourId, @RequestBody TourPlace place){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.addPlaceToTour(tourId,place));
    }


    @PatchMapping("{tourId}/share")
    public ResponseEntity shareTourWhitOtherUser(@RequestParam("userId") Long userId, @PathVariable("tourId") Long tourId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tourService.shareTourWithOtherUser(tourId, userId));
    }
}
