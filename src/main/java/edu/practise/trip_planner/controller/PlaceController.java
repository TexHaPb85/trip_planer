package edu.practise.trip_planner.controller;


import edu.practise.trip_planner.entities.Place;
import edu.practise.trip_planner.service.place.PlaceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlaceController {
    private final PlaceServiceImpl placeService;

    public PlaceController(PlaceServiceImpl placeService) {
        this.placeService = placeService;
    }

    @PostMapping("/place")
    @ResponseBody
    public ResponseEntity addPlace(@RequestBody Place place){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.addPlace(place));
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity deletePlaceById(@PathVariable("id") Long id ){
        placeService.deletePlaceById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The place deleted");
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Place> findPlaceById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.findPlaceById(id));
    }

    @PutMapping("/place/{id}")
    @ResponseBody
    public ResponseEntity editPlaceById(@PathVariable("id") Long id, @RequestBody Place place){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The place edited" + placeService.editPlaceById(id, place));
    }
}
