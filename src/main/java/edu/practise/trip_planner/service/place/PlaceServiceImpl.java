package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.Comment;
import edu.practise.trip_planner.entities.TourPlace;
import edu.practise.trip_planner.exceptions.PlaceNotFoundException;
import edu.practise.trip_planner.repository.CommentsRepository;
import edu.practise.trip_planner.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final CommentsRepository commentsRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository, CommentsRepository commentsRepository) {
        this.placeRepository = placeRepository;
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comment> findCommentsByPlaceId(Long id) {
        return commentsRepository.findCommentsByPlaceId(id);
    }

    @Override
    public Comment addCommentToPlace(Long placeId, Comment comment) {
        TourPlace place = placeRepository
                .findById(placeId)
                .orElseThrow(() -> new PlaceNotFoundException("The tourPlace with id " + placeId + " doesn't found"));
        comment.setPlace(place);
        return commentsRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentsRepository.deleteById(id);
    }

    @Override
    public List<TourPlace> findAllPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public TourPlace addPlace(TourPlace tourPlace) {
        return placeRepository.save(tourPlace);
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public TourPlace getPlaceById(Long id) {
        return placeRepository
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException("The place with id " + id + " doesn't found"));
    }

    public Optional<TourPlace> findPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    @Override
    public TourPlace editPlaceById(Long id, TourPlace tourPlace) {
        TourPlace editedTourPlace = placeRepository
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException("The tourPlace with id " + id + " doesn't found"));

        editedTourPlace.setName(tourPlace.getName());
        editedTourPlace.setRates(tourPlace.getRates());

        return placeRepository.save(editedTourPlace);
    }
}
