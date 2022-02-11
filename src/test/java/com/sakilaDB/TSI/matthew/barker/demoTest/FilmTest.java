package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Actor;
import com.sakilaDB.TSI.matthew.barker.demo.Film;
import org.junit.jupiter.api.Test;

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


    @Test
    public void test_constructor(){
        Film film = new Film();

        assertTrue(film instanceof Film, "Not an instance of Film");
    }
}
