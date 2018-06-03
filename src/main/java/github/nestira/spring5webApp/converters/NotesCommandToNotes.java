package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.NotesCommand;
import github.nestira.spring5webApp.models.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NotesCommand notesCommand) {

        if (null == notesCommand)
            return null;

        Note notes = new Note();
        notes.setId(notesCommand.getId());
        notes.setRecipeNote(notesCommand.getRecipeNotes());

        return notes;
    }
}
