package com.sakilaDB.TSI.matthew.barker.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int length;
    private String rating;
    private String special_features;


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