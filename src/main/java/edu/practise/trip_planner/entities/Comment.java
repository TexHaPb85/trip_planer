package edu.practise.trip_planner.entities;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_Id")
    private Long id;

    @Column(name = "text_of_comment")
    private String text;

    @ManyToOne
    @JoinColumn(name = "place_Id")
    private TourPlace place;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public TourPlace getPlace() {
        return place;
    }

    public void setPlace(TourPlace place) {
        this.place = place;
    }
}
