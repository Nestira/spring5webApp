package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.converters.RecipeCommandToRecipe;
import github.nestira.spring5webApp.converters.RecipeToRecipeCommand;
import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {


    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception {
            MockitoAnnotations.initMocks(this); //Create Mock objects for this class.

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipesTest() {

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 0);

        // If you need the Mock object to return something different:
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe); // Create the return object your want.

        when(recipeService.getRecipes()).thenReturn(recipesData);

        recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1); //true
        verify(recipeRepository, times(2)).findAll();

    }

    @Test
    public void getRecipeByIdTest() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);
        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}