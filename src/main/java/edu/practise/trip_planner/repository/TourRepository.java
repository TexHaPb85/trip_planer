package edu.practise.trip_planner.repository;


import edu.practise.trip_planner.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
}