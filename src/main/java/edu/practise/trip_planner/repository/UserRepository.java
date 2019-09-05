package edu.practise.trip_planner.repository;


import edu.practise.trip_planner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}