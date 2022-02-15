package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest {

    @Test
    public void testName() {

        Language testName = new Language();
        testName.setName("Greek");
        assertEquals("Greek", testName.getName(), "Incorrect name!");
    }


    private Language language = new Language();

    @Test
    public void test_constructor() {
        assertTrue(language instanceof Language, "Not an instance of Actor");
    }
}
