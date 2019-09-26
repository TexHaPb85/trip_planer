package edu.practise.trip_planner.repository;

import edu.practise.trip_planner.entities.Comment;
import edu.practise.trip_planner.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsByAuthor(User user);

    List<Comment> findCommentsByPlaceId(Long placeId);
}
