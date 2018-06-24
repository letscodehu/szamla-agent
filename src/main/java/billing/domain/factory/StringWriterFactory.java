package billing.domain.factory;

import java.io.StringWriter;

/**
 * Factory for creating StringWriters for testing.
 */
public class StringWriterFactory {

    /**
     * Creates a new StringWriter instance.
     * @return StringWriter
     */
    public StringWriter create() {
        return new StringWriter();
    }

}
