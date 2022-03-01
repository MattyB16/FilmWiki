package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Actor;
import com.sakilaDB.TSI.matthew.barker.demo.Film;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    @Test
    public void testFirstName() {

        Actor testFirstName = new Actor();
        testFirstName.setFirstName("Big");
        assertEquals("Big", testFirstName.getFirstName(), "Incorrect first name!");
    }

    @Test
    public void testLastName() {

        Actor testLastName = new Actor();
        testLastName.setLastName("Jeff");
        assertEquals("Jeff", testLastName.getLastName(), "Incorrect first name!");
    }

    private Actor actor = new Actor();

    @Test
    public void test_constructor() {
        assertTrue(actor instanceof Actor, "Not an instance of Actor");
    }

    private Set<Film> testFilmSet = new HashSet<>() {{
        add(new Film("1", "1", 1, 1, "1", 1));
    }};

    Actor testActor = new Actor("me", "you");

//    @Test
//    public void testGetFilms() {
//        testActor.setFilm(testFilmSet);
//        assertEquals(testFilmSet, testActor.getFilm(), "Incorrect Actor getting");
//    }
//
//    @Test
//    public void testSetFilmSet() {
//        testFilmSet.add(new Film("1", "1", 1, 1, "1", 1));
//        testActor.setFilm(testFilmSet);
//        assertEquals(testFilmSet, testActor.getFilm(), "Incorrect Actor setting");
//    }


    @Test
    public void testGetActor_id(){
        assertEquals(0, actor.getActor_id(), "actor id getting failed");
    }
}
