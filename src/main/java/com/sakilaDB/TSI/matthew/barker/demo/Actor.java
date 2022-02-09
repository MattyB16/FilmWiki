package com.sakilaDB.TSI.matthew.barker.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;
    private String first_name;
    private String last_name;

    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> film = new HashSet<>();

    public Actor(String first_name, String last_name){

        this.first_name=first_name;
        this.last_name=last_name;

    }

    public Actor(){

    }

    public Set<Film> getFilm() {
        return film;
    }

    public void setFilm(Set<Film>film){
        this.film = film;
    }

    public int getActor_id() {
        return actor_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }
}