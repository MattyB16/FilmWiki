package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Actor;
import com.sakilaDB.TSI.matthew.barker.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilmTest {

    @Test
    public void testGetRating() {

        Film testRating = new Film();
        testRating.setRating("Big");
        assertEquals("Big",testRating.getRating(),  "Incorrect rating");
    }

    @Test
    public void testGetLength() {

        Film testLength = new Film();
        testLength.setLength(23);
        assertEquals(23,testLength.getLength(),  "Incorrect length!");
    }

    @Test
    public void testGetRelease_year() {

        Film testRelease_year = new Film();
        testRelease_year.setRelease_year(2020);
        assertEquals(2020,testRelease_year.getRelease_year(),  "Incorrect Release year!");
    }

    @Test
    public void testGetDescription() {

        Film testDescription = new Film();
        testDescription.setDescription("good");
        assertEquals("good",testDescription.getDescription(),  "Incorrect Description!");
    }

    @Test
    public void testGetTitle() {

        Film testTitle = new Film();
        testTitle.setTitle("Big Jeff the Movie");
        assertEquals("Big Jeff the Movie",testTitle.getTitle(),  "Incorrect Title!");
    }

    @Test
    public void testGetLanguage_id() {

        Film testLanguage_id= new Film();
        testLanguage_id.setLanguage_id(3);
        assertEquals(3,testLanguage_id.getLanguage_id(),  "Incorrect Language ID!");
    }

    private Set<Actor> testActorSet = new HashSet<>(){{
        add(new Actor("Me","You"));
    }};

    Film testFilm = new Film("1","1",1,1,"1",1);

    @Test
    public void testGetActors() {
        testFilm.setActors(testActorSet);
        assertEquals(testActorSet, testFilm.getActors(),  "Incorrect Actor getting");
    }

    @Test
    public void testSetActor(){
        testActorSet.add(new Actor("me","you"));
        testFilm.setActors(testActorSet);
        assertEquals(testActorSet, testFilm.getActors(), "Incorrect Actor setting");
    }

    @Test
    public void test_constructorFilm(){
        Film film = new Film();

        assertTrue(film instanceof Film, "Not an instance of Film");
    }

    @Test
    public void test_constructorActor(){
        Actor actor = new Actor();

        assertTrue(actor instanceof Actor, "Not an instance of Actor");
    }

    private List testReview;

    @Test
    public void testGetReview(){
        testFilm.setReviews(testReview);
        assertEquals(testReview, testFilm.getReviews(), "Review setting or getting failed");
    }

    private Film film = new Film();
    @Test
    public void testGetFilm_id(){
        assertEquals(0, film.getFilm_id(), "film id getting failed");
    }
}
