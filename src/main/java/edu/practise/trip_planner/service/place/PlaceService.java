package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.Place;

public interface PlaceService {
    Place addPlace(Place place);

    void deletePlaceById(Long id);

    Place findPlaceById(Long id);

    Place editPlaceById(Long id, Place place);
}
