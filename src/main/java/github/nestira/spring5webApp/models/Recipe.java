package github.nestira.spring5webApp.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"prepTime", "cookTime", "servings", "source", "directions", "ingredients", "image",
        "note", "categories"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings; // The number of people it could serve
    private String source;
    private String url;

    @Lob
    private String directions;

    @Enumerated(value = EnumType.STRING) //ORDINAL is the default.
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // Owner shall be in the "One" side
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Note note;

    @ManyToMany
    @JoinTable(name = "recipe_category_foo", joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    // JoinTable so that only one mapping table is created. Otherwise, two mapping tables is created for each direction
    private Set<Category> categories = new HashSet<>();

    public void setNote(Note note) {
        this.note = note;

        if (null != note)
            note.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
