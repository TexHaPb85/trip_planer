package edu.practise.trip_planner.controller;

import edu.practise.trip_planner.entities.Comment;
import edu.practise.trip_planner.service.place.PlaceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("places")
public class CommentsController {
    private final PlaceServiceImpl placeService;

    public CommentsController(PlaceServiceImpl placeService) {
        this.placeService = placeService;
    }

    @PostMapping("{placeId}/comments")
    public ResponseEntity addCommentAboutPlace(@PathVariable("placeId") Long placeID, @RequestBody Comment comment) {
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
