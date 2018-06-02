package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.CategoryCommand;
import github.nestira.spring5webApp.models.Category;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        return null;
    }
}
