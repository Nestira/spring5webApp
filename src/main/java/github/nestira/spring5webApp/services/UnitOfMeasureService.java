package github.nestira.spring5webApp.services;

import github.nestira.spring5webApp.commands.UnitOfMeasureCommand;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UnitOfMeasureService {

    public Set<UnitOfMeasureCommand> listAllUoms();
}
