package github.nestira.spring5webApp.controllers;

import github.nestira.spring5webApp.commands.RecipeCommand;
import github.nestira.spring5webApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/show/{id}"})
    public String GetRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping({"/recipe/new"})
    public String newRecipe(Model model) {

        model.addAttribute("recipe", new RecipeCommand()); //"recipe" match object name in html.
        return "recipe/recipeform";
    }

    @PostMapping({"/recipe/"}) //match "th:action" in the form or object name? Maybe it has to match both
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {

        log.debug(command.getDescription());
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/show/" + savedCommand.getId();
    }
}
