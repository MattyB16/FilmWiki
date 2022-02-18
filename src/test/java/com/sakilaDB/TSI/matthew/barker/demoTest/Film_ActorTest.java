package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Film_Actor;
import com.sakilaDB.TSI.matthew.barker.demo.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Film_ActorTest {

    @Test
    public void testFilmId() {

        Film_Actor testFilmId = new Film_Actor();
        testFilmId.setFilm_id(1);
        assertEquals(1, testFilmId.getFilm_id(), "Incorrect Film Id!");
    }

    @Test
    public void testActorId() {

        Film_Actor testActorId = new Film_Actor();
        testActorId.setActor_id(1);
        assertEquals(1, testActorId.getActor_id(), "Incorrect Actor Id!");
    }


    private Film_Actor film_actor = new Film_Actor();

    @Test
    public void test_constructor() {
        assertTrue( film_actor instanceof Film_Actor, "Not an instance of Film_Actor");
    }

}
