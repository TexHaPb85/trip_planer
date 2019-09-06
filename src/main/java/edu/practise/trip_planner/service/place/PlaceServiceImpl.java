package edu.practise.trip_planner.service.place;


import edu.practise.trip_planner.entities.TourPlace;
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
    public TourPlace addPlace(TourPlace tourPlace) {
        return placeRepository.save(tourPlace);
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public TourPlace findPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new PlaceNotFoundException("The place with id " + id + " doesn't found"));
    }

    @Override
    public TourPlace editPlaceById(Long id, TourPlace tourPlace) {
        TourPlace editedTourPlace = placeRepository
                .findById(id)
                .orElseThrow(() -> new PlaceNotFoundException("The tourPlace with id " + id + " doesn't found"));

        editedTourPlace.setName(tourPlace.getName());
        editedTourPlace.setComments(tourPlace.getComments());
        editedTourPlace.setRates(tourPlace.getRates());

        return placeRepository.save(editedTourPlace);
    }
}
