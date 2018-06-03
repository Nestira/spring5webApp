package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.UnitOfMeasureCommand;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {

        if (null == unitOfMeasure)
            return null;

        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(unitOfMeasure.getId());
        command.setDescription(unitOfMeasure.getDescription());

        return command;
    }
}
