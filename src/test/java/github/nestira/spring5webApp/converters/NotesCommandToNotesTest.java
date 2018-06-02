package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.NotesCommand;
import github.nestira.spring5webApp.models.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Notes";
    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        NotesCommand command = new NotesCommand();
        command.setID(ID_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        //when
        Note notes = converter.convert(command);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNote());
    }

}