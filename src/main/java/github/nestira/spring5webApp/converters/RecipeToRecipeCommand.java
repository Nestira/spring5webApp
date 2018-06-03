package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.CategoryCommand;
import github.nestira.spring5webApp.commands.IngredientCommand;
import github.nestira.spring5webApp.commands.RecipeCommand;
import github.nestira.spring5webApp.models.Category;
import github.nestira.spring5webApp.models.Ingredient;
import github.nestira.spring5webApp.models.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter,
                                 IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe recipe) {

        if (null == recipe)
            return null;

        RecipeCommand command = new RecipeCommand();
        command.setId(recipe.getId());
        command.setDescription(recipe.getDescription());
        command.setCookTime(recipe.getCookTime());
        command.setPrepTime(recipe.getPrepTime());
        command.setDifficulty(recipe.getDifficulty());
        command.setUrl(recipe.getUrl());
        command.setServings(recipe.getServings());
        command.setDirections(recipe.getDirections());
        command.setSource(recipe.getSource());
        command.setNotesCommand(notesConverter.convert(recipe.getNote()));

        Set<CategoryCommand> categoryCommands = new HashSet<>();
        for (Category category : recipe.getCategories()) {
            categoryCommands.add(categoryConverter.convert(category));
        }
        command.setCategories(categoryCommands);

        Set<IngredientCommand> ingredientCommands = new HashSet<>();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredientCommands.add(ingredientConverter.convert(ingredient));
        }
        command.setIngredients(ingredientCommands);

        return command;
    }
}
