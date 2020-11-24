package hu.letscode.billing.domain.marshaller;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Converts the xml responses to actual classes.
 */
public class ResponseUnmarshaller {

    private final JAXBContext jaxbContext;

    /**
     *  Standard constructor.
     * */
    public ResponseUnmarshaller(JAXBContext jaxbContext) {
        this.jaxbContext = jaxbContext;
    }

    /**
     * Unmarshalls the response from the given stream to the specified type.
     * @return the response as the type specified.
     */
    public <T> T marshallResponse(InputStream stream, Class<T> type) throws JAXBException {
        return (T) jaxbContext.createUnmarshaller().unmarshal(stream);
    }

}
