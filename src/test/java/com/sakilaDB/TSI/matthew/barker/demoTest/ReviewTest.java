package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Film;
import com.sakilaDB.TSI.matthew.barker.demo.Language;
import com.sakilaDB.TSI.matthew.barker.demo.Review;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewTest {

    @Test
    public void testFilmId() {

        Review testFilmId = new Review();
        testFilmId.setFilm_id(1);
        assertEquals(1, testFilmId.getFilm_id(), "Incorrect name!");
    }

    @Test
    public void testConsumerReview() {

        Review testReview = new Review();
        testReview.setConsumer_review("stuff");
        assertEquals("stuff", testReview.getConsumer_review(), "Incorrect review!");
    }
    private Review review = new Review();

    @Test
    public void test_constructor() {
        assertTrue(review instanceof Review, "Not an instance of Review");
    }

    @Test
    public void testGetReview_id(){
            assertEquals(0, review.getReview_id(), "Review id getting or setting failed");
    }
}
