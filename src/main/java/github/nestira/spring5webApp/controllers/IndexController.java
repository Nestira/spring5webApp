package github.nestira.spring5webApp.controllers;

import github.nestira.spring5webApp.models.Category;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import github.nestira.spring5webApp.repositories.RecipeRepository;
import github.nestira.spring5webApp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Cup");
        System.out.println("Cup Id is: " + unitOfMeasure.get().getId());
        return "index";
    }
}
