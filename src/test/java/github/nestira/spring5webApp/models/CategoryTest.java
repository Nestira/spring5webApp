package github.nestira.spring5webApp.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before // Run before each test
    public  void setUp() {
        category = new Category();
    }
    @Test
    public void getId() {
        Long id = 4L;

        category.setId(id);

        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}