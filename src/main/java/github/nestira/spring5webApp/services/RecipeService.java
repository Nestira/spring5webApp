package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.commands.RecipeCommand;
import github.nestira.spring5webApp.models.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    public Set<Recipe> getRecipes();
    public Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand testRecipeCommand);

    RecipeCommand findCommandById(Long l);

    void deleteById(Long l);
}
