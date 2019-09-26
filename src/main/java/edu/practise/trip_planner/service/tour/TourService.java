package edu.practise.trip_planner.service.tour;

import edu.practise.trip_planner.entities.Tour;
import edu.practise.trip_planner.entities.TourPlace;
import edu.practise.trip_planner.entities.User;

import java.util.List;

public interface TourService {
    Tour addTour(Tour tour);

    Tour addUserToTour(Long tourId, User user);

    Tour addPlaceToTour(Long tourId, TourPlace place);

    void deleteTourById(Long id);

    Tour editTourById(Long tourId, Tour newTour);

    Tour shareTourWithOtherUser(Long tripId, Long userId);

    Tour findTourById(Long id);

    List<Tour> findAllTours();
}
