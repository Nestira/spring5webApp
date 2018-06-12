package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.commands.IngredientCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long aLong, Long aLong1);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteByRecipeIdAndIngredientId(Long aLong, Long aLong1);
}
