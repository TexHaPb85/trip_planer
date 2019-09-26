package edu.practise.trip_planner.repository;


import edu.practise.trip_planner.entities.TourPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<TourPlace, Long> {
}
