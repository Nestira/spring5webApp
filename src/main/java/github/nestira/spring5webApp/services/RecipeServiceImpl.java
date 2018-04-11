package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();

        for (Recipe recipe : recipeRepository.findAll()) {
            recipeSet.add(recipe);
        }

        return recipeSet;
    }
}