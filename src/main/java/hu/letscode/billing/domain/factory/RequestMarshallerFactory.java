package hu.letscode.billing.domain.factory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;

/**
 * Factory for creating {@link RequestMarshaller} instances.
 */
public class RequestMarshallerFactory {

    /**
     * Creates a new {@link RequestMarshallerFactory}.
     * @return RequestMarshallerFactory
     */
    public static RequestMarshallerFactory newInstance() {
        return new RequestMarshallerFactory();
    }

    /**
     * Creates a new {@link RequestMarshaller}.
     * @return RequestMarshaller
     * @throws JAXBException when marshalling issue occur.
     */
    public RequestMarshaller create() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(BillingRequest.class);
        return new RequestMarshaller(context, new StringWriterFactory());
    }
}
