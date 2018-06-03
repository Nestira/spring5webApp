package github.nestira.spring5webApp.converters;

import github.nestira.spring5webApp.commands.IngredientCommand;
import github.nestira.spring5webApp.models.Ingredient;
import github.nestira.spring5webApp.models.Recipe;
import github.nestira.spring5webApp.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "Cheeseburger";
    public static final Long UOM_ID = 2L;
    public static final Long ID_VALUE = 2L;


    IngredientToIngredientCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullConvert() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Ingredient()));
    }

    @Test
    public void testConvertNullUOM() throws Exception {
        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setUom(null);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertNull(command.getUnitOfMeasureCommand());
        assertEquals(ID_VALUE, command.getId());
//        assertEquals(RECIPE, command.getRecipe());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescription());
    }

    @Test
    public void testConvertWithUOM() throws Exception {

        //given
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setRecipe(RECIPE);
        ingredient.setAmount(AMOUNT);
        ingredient.setDescription(DESCRIPTION);

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(UOM_ID);

        ingredient.setUom(uom);

        //when
        IngredientCommand command = converter.convert(ingredient);

        //then
        assertEquals(ID_VALUE, command.getId());
        assertNotNull(command.getUnitOfMeasureCommand());
        assertEquals(UOM_ID, command.getUnitOfMeasureCommand().getId());
//        assertEquals(RECIPE, command.getRecipe());
        assertEquals(AMOUNT, command.getAmount());
        assertEquals(DESCRIPTION, command.getDescription());

    }
}