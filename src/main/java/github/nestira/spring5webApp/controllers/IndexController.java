package github.nestira.spring5webApp.controllers;

import github.nestira.spring5webApp.models.Category;
import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import github.nestira.spring5webApp.repositories.RecipeRepository;
import github.nestira.spring5webApp.repositories.UnitOfMeasureRepository;
import github.nestira.spring5webApp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.Set;

@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {

        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "index";
    }
}
