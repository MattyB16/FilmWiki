package com.sakilaDB.TSI.matthew.barker.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int length;
    private String rating;
    private String special_features;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();


    public Film(String title,String description, int release_year, int length, String rating, String special_features){

        this.title=title;
        this.description=description;
        this.release_year=release_year;
        this.length=length;
        this.rating=rating;
        this.special_features=special_features;

    }

    public Film(){

    }

    public Set<Actor> getActors() {
        return actor;
    }

    public void setActors(Set<Actor> actor) {
        this.actor = actor;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }
}