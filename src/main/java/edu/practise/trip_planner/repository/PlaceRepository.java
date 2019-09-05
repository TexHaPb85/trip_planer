package edu.practise.trip_planner.repository;


import edu.practise.trip_planner.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
