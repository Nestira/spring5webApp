package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.IngredientCommand;
import github.nestira.spring5webApp.models.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {

        if (null == source)
            return null;

        IngredientCommand command = new IngredientCommand();

        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setAmount(source.getAmount());
        command.setUnitOfMeasureCommand(
                uomConverter.convert(source.getUom())
        );

        return command;
    }
}
