package billing.domain.factory;

import billing.domain.BillingRequest;
import billing.domain.marshaller.RequestMarshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 * Factory for creating {@link RequestMarshaller} instances.
 */
public class RequestMarshallerFactory {

    /**
     * Creates a new {@link RequestMarshaller}.
     * @return RequestMarshaller
     * @throws JAXBException
     */
    public RequestMarshaller create() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(BillingRequest.class);
        return new RequestMarshaller(context, new StringWriterFactory());
    }

    /**
     * Creates a new {@link RequestMarshallerFactory}.
     * @return RequestMarshallerFactory
     */
    public static RequestMarshallerFactory newInstance() {
        return new RequestMarshallerFactory();
    }
}
