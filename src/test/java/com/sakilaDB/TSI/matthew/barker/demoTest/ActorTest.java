package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Actor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorTest {

    private int actor_id;
    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    @Test
    public void testFirstName() {

        Actor testFirstName = new Actor();
        testFirstName.setFirstName("Big");
        assertEquals("Big",testFirstName.getFirstName(),  "Incorrect first name!");
    }

    @Test
    public void testLastName() {

        Actor testLastName = new Actor();
        testLastName.setLastName("Jeff");
        assertEquals("Jeff",testLastName.getLastName(),  "Incorrect first name!");
    }

    private Actor actor = new Actor();

    @Test
    public void test_constructor(){
        assertTrue(actor instanceof Actor, "Not an instance of Actor");
    }
}
