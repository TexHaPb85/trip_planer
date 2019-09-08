package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.Comment;
import edu.practise.trip_planner.entities.TourPlace;

import java.util.List;

public interface PlaceService {
    List<Comment> findCommentsByPlaceId(Long id);

    Comment addCommentToPlace(Long placeId, Comment comment);

    void deleteCommentById(Long id);

    List<TourPlace> findAllPlaces();

    TourPlace addPlace(TourPlace tourPlace);

    void deletePlaceById(Long id);

    TourPlace findPlaceById(Long id);

    TourPlace editPlaceById(Long id, TourPlace tourPlace);
}
