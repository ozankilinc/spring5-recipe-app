package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {
    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);
    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullObject() throws  Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmpteyObject() throws Exception {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then

        assertEquals(LONG_VALUE,category.getId());
        assertEquals(DESCRIPTION,category.getDescription());
    }
}