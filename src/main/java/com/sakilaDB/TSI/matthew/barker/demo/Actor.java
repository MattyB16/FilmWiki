package com.sakilaDB.TSI.matthew.barker.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int actor_id;
    private String first_name;
    private String last_name;

    public Actor(String first_name, String last_name){

        this.first_name=first_name;
        this.last_name=last_name;

    }

    public Actor(){

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