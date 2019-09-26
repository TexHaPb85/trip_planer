package edu.practise.trip_planner.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "places")
public class TourPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_Id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "rates")
    @ElementCollection(targetClass = Float.class)
    private List<Float> rates;

    public TourPlace() {
    }

    public TourPlace(String name, List<Float> rates) {
        this.name = name;
        this.rates = rates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Float> getRates() {
        return rates;
    }

    public void setRates(List<Float> rates) {
        this.rates = rates;
    }
}