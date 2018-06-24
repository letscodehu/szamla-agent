package billing.domain.marshaller;

import billing.domain.Language;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Krisztian_Papp
 * Test class for {@link LanguageTypeAdapter}.
 */
public class LanguageTypeAdapterTest {

    private LanguageTypeAdapter underTest;

    @Before
    public void setUp() {
        underTest = new LanguageTypeAdapter();
    }

    @Test
    public void unmarshalShouldReturnLanguageByString() throws Exception {
        // GIVEN
        String language = "hu";
        // WHEN
        Language actual = underTest.unmarshal(language);
        // THEN
        assertEquals(Language.HU, actual);
    }

    @Test
    public void marshalShouldReturnStringByLanguage() throws Exception {
        // GIVEN
        Language language = Language.EN;
        // WHEN
        String actual = underTest.marshal(language);
        // THEN
        assertEquals("en", actual);
    }

}