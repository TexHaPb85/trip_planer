package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.TourPlace;

public interface PlaceService {
    TourPlace addPlace(TourPlace tourPlace);

    void deletePlaceById(Long id);

    TourPlace findPlaceById(Long id);

    TourPlace editPlaceById(Long id, TourPlace tourPlace);
}
