package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    public Set<Recipe> getRecipes();
}