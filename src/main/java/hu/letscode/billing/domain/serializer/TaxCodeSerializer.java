package hu.letscode.billing.domain.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import hu.letscode.billing.domain.TaxCode;

public class TaxCodeSerializer extends JsonSerializer<TaxCode> {

    @Override
    public void serialize(TaxCode value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(value.getValue());
    }

}
