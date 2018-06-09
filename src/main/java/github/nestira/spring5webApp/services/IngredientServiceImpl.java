package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.commands.IngredientCommand;
import github.nestira.spring5webApp.models.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {

    //todo: Service does not rely on other service. Use repository to get data.
    private final RecipeService recipeService;

    public IngredientServiceImpl(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Recipe recipe = recipeService.findById(recipeId);

        return null;
    }
}
