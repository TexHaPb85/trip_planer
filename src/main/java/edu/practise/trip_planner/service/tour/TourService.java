package edu.practise.trip_planner.service.tour;

import edu.practise.trip_planner.entities.Tour;

import java.util.List;

public interface TourService {
    Tour addTour(Long userId, Tour tour);

    void deleteTourById(Long id);

    Tour editTourById(Long id, Long tripId, Tour trip);

    Tour shareTourWithOtherUser(Long tripId, Long userId);

    Tour findTourById(Long id);

    List<Tour> findAllTours();
}
