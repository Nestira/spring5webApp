package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.NotesCommand;
import github.nestira.spring5webApp.models.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Note, NotesCommand> {

    @Synchronized
    @Nullable
    @Override
    public NotesCommand convert(Note note) {

        if (null == note)
            return null;

        NotesCommand command = new NotesCommand();

        command.setId(note.getId());
        command.setRecipeNotes(note.getRecipeNote());

        return command;
    }
}
