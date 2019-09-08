package edu.practise.trip_planner.controller;


import edu.practise.trip_planner.entities.Comment;
import edu.practise.trip_planner.entities.TourPlace;
import edu.practise.trip_planner.service.place.PlaceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController {
    private final PlaceServiceImpl placeService;

    public PlaceController(PlaceServiceImpl placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<TourPlace> findAllPlaces() {
        return placeService.findAllPlaces();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity addPlace(@RequestBody TourPlace tourPlace) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.addPlace(tourPlace));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePlaceById(@PathVariable("id") Long id) {
        placeService.deletePlaceById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The place deleted");
    }

    @GetMapping("{id}")
    public ResponseEntity<TourPlace> findPlaceById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.findPlaceById(id));
    }

    @PutMapping("{id}")
    @ResponseBody
    public ResponseEntity editPlaceById(@PathVariable("id") Long id, @RequestBody TourPlace tourPlace) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The tourPlace edited" + placeService.editPlaceById(id, tourPlace));
    }

    @PostMapping("{id}/comments")
    public ResponseEntity addCommentAboutPlace(@PathVariable("id") Long placeID, @RequestBody Comment comment) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.addCommentToPlace(placeID, comment));
    }

    @DeleteMapping("{placeId}/comments/{commentForDeleteId}")
    public ResponseEntity deleteCommentById(@PathVariable("placeId") Long placeId,
                                            @PathVariable("commentForDeleteId") Long commentForDeleteId) {
        placeService.deleteCommentById(commentForDeleteId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The comment to place " + placeId + " with id " + commentForDeleteId + "was removed");
    }

    @GetMapping("{id}/comments")
    public ResponseEntity getCommentsById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.findCommentsByPlaceId(id));
    }


}
