package github.nestira.spring5webApp.repositories;

import github.nestira.spring5webApp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Override
    Optional<Recipe> findById(Long aLong);

    Optional<Recipe> findByDescription(String description);
}
