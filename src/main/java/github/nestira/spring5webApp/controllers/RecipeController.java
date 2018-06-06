package github.nestira.spring5webApp.controllers;

import github.nestira.spring5webApp.commands.RecipeCommand;
import github.nestira.spring5webApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipe/{id}/show"})
    public String GetRecipe(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @RequestMapping({"/recipe/new"})
    public String newRecipe(Model model) {

        model.addAttribute("recipe", new RecipeCommand()); //"recipe" match object name in html.
        return "recipe/recipeform";
    }

    @PostMapping({"/recipe"}) //match "th:action" in the form or object name? Maybe it has to match both
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {

        log.debug(command.getDescription());
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @RequestMapping("/recipe/{id}/update")
    public String getUpdateForm(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/recipeform";
    }

    @GetMapping("/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {

        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
