package github.nestira.spring5webApp.repositories;

import github.nestira.spring5webApp.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
