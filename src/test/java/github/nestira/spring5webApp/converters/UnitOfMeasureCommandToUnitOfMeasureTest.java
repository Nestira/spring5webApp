package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.UnitOfMeasureCommand;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "Description: UnitOfMeasureCommand To UnitOfMeasure";
    public static final Long ID_VALUE = 1L;

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testNullObject() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void testConvert() throws Exception {

        //Given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(ID_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uofm = converter.convert(command);

        //then
        assertNotNull(uofm);
        assertEquals(ID_VALUE, uofm.getId());
        assertEquals(DESCRIPTION, uofm.getDescription());
    }

}