package github.nestira.spring5webApp.repositories;

import github.nestira.spring5webApp.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String decription);
}
