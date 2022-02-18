package com.sakilaDB.TSI.matthew.barker.demoTest;

import com.sakilaDB.TSI.matthew.barker.demo.Category;
import com.sakilaDB.TSI.matthew.barker.demo.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CategoryTest {


    @Test
    public void testName() {

        Category testName = new Category();
        testName.setName("Horror");
        assertEquals("Horror", testName.getName(), "Incorrect name!");
    }


    private Category category = new Category();

    @Test
    public void test_constructor() {
        assertTrue(category instanceof Category, "Not an instance of Category");
    }

    @Test
    public void testGetCategory_id(){
        assertEquals(0, category.getCategory_id(), "Category id getting failed");
    }
}
