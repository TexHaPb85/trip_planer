package edu.practise.trip_planner.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_Id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tours")
    @ElementCollection(targetClass = User.class)
    private List<User> users = new ArrayList<>();

    @Column(name = "tourPlaces")
    @ElementCollection(targetClass = TourPlace.class)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "place_tour", joinColumns = @JoinColumn(name = "tour_id"), inverseJoinColumns = @JoinColumn(name = "place_id"))
    private List<TourPlace> tourPlaces = new ArrayList<>();

    public Tour() {
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

    public List<User> getUsers() {
        return users;
    }

    public List<TourPlace> getTourPlaces() {
        return tourPlaces;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setTourPlaces(List<TourPlace> tourPlaces) {
        this.tourPlaces = tourPlaces;
    }
}
