package hu.letscode.billing.domain.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import hu.letscode.billing.domain.Language;

import java.io.IOException;

public class LanguageSerializer extends JsonSerializer<Language> {

    @Override
    public void serialize(Language language, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(language.toString().toLowerCase());
    }
}
