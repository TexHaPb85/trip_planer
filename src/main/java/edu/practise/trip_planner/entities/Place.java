package edu.practise.trip_planner.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "places")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_Id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "comments")
    @ElementCollection(targetClass = String.class)
    private List<String> comments;

    @Column(name = "rates")
    @ElementCollection(targetClass = Float.class)
    private List<Float> rates;

    public Place(String name, List<String> comments, List<Float> rates) {
        this.name = name;
        this.comments = comments;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public List<Float> getRates() {
        return rates;
    }

    public void setRates(List<Float> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comments=" + comments +
                ", rates=" + rates +
                '}';
    }
}