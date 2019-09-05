package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.Place;
import edu.practise.trip_planner.exceptions.PlaceNotFoundException;
import edu.practise.trip_planner.repository.PlaceRepository;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public Place findPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new PlaceNotFoundException("The place with id " + id + " doesn't found"));
    }

    @Override
    public Place editPlaceById(Long id, Place place) {
        Place editedPlace = placeRepository
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException("The place with id " + id + " doesn't found"));

        editedPlace.setName(place.getName());
        editedPlace.setComments(place.getComments());
        editedPlace.setRates(place.getRates());

        return placeRepository.save(editedPlace);
    }
}
