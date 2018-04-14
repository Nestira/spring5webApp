package github.nestira.spring5webApp.controllers;

import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    private IndexController controller;

    @Mock
    private RecipeService recipeService;

    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {

        //Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        Recipe recipe = new Recipe();
        recipe.setDescription("This is a description");
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);


        String templateName = controller.getIndexPage(model);

        assertEquals("index", templateName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        assertEquals(recipes.size(), argumentCaptor.getValue().size());
    }
}