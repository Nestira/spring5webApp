package github.nestira.spring5webApp.commands;

import github.nestira.spring5webApp.models.Category;
import github.nestira.spring5webApp.models.Difficulty;
import github.nestira.spring5webApp.models.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String directions;
    private Difficulty difficulty;
    private String url;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Set<CategoryCommand> categories = new HashSet<>();
    private NotesCommand notesCommand;

}
