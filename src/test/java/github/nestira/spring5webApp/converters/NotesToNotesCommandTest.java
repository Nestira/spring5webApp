package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.NotesCommand;
import github.nestira.spring5webApp.models.Note;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTES = "Notes";
    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }

    @Test
    public void testConvert() throws Exception {

        //given
        Note notes = new Note();
        notes.setRecipeNote(RECIPE_NOTES);
        notes.setId(ID_VALUE);

        //when
        NotesCommand command = converter.convert(notes);

        //then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(RECIPE_NOTES, command.getRecipeNotes());
    }

}