package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.UnitOfMeasureCommand;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "Description: UnitOfMeasure To UnitOfMeasureCommand";
    public static final Long ID_VALUE = 1L;

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void testConvert() throws Exception {

        //Given
        UnitOfMeasure uofm = new UnitOfMeasure();
        uofm.setId(ID_VALUE);
        uofm.setDescription(DESCRIPTION);

        //When
        UnitOfMeasureCommand command = converter.convert(uofm);

        //Then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}