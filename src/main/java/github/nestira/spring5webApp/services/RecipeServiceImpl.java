package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.commands.RecipeCommand;
import github.nestira.spring5webApp.converters.RecipeCommandToRecipe;
import github.nestira.spring5webApp.converters.RecipeToRecipeCommand;
import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;

        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");

        Set<Recipe> recipeSet = new HashSet<>();

        for (Recipe recipe : recipeRepository.findAll()) {
            recipeSet.add(recipe);
        }

        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }

    @Override
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand testRecipeCommand) {

        Recipe detachedRecipe = recipeCommandToRecipe.convert(testRecipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe id: " + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }

}
