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
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final IngredientCommandToIngredient ingredientConverter;
    private final CategoryCommandToCategory categoryConverter;
    private final NotesCommandToNotes noteConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter,
                                 IngredientCommandToIngredient ingredientConverter,
                                 NotesCommandToNotes noteConverter) {
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
        this.noteConverter = noteConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {

        if (null == recipeCommand)
            return null;

        Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setServings(recipeCommand.getServings());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setSource(recipeCommand.getSource());
        recipe.setNote(
                noteConverter.convert(recipeCommand.getNotesCommand())
        );

        Set<Category> categories = new HashSet<>();
        for (CategoryCommand categoryCommand : recipeCommand.getCategories()) {
            categories.add(categoryConverter.convert(categoryCommand));
        }
        recipe.setCategories(categories);

        Set<Ingredient> ingredients = new HashSet<>();
        for (IngredientCommand command : recipeCommand.getIngredients()) {
            ingredients.add(ingredientConverter.convert(command));
        }
        recipe.setIngredients(ingredients);

        return recipe;
    }
}
