package hu.letscode.billing.domain.marshaller;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

/**
 * @author Krisztian_Papp
 * Test class for {@link LocalDateAdapter}.
 */

public class LocalDateAdapterTest {

    private LocalDateAdapter underTest;

    @Before
    public void setUp() {
        underTest = new LocalDateAdapter();
    }

    @Test
    public void marshalShouldReturnStringFromDate() throws Exception {
        // GIVEN
        LocalDateTime date = LocalDateTime.of(2017,5,11,0,0,0);
        // WHEN
        String actual = underTest.marshal(date);
        // THEN
        assertEquals("2017-05-11", actual);
    }

    @Test
    public void mashalShouldReturnDateFromString() throws Exception {
        // GIVEN
        String date = "2017-05-11T00:00:00";
        // WHEN
        LocalDateTime actual = underTest.unmarshal(date);
        // THEN
        assertEquals(LocalDateTime.of(2017,5,11,0,0), actual);

    }
}