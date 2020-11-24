package hu.letscode.billing.domain.factory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import hu.letscode.billing.domain.BillingCreateResponse;
import hu.letscode.billing.domain.marshaller.ResponseUnmarshaller;

public class ResponseUnmarshallerFactory {

    /**
     * Creates a new {@link ResponseUnmarshallerFactory}.
     * @return {@link ResponseUnmarshallerFactory}
     */
    public static ResponseUnmarshallerFactory newInstance() {
        return new ResponseUnmarshallerFactory();
    }

    /**
     * Creates a new {@link ResponseUnmarshaller}.
     * @return {@link ResponseUnmarshaller}
     * @throws JAXBException when marshalling issue occur.
     */
    public ResponseUnmarshaller create() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(BillingCreateResponse.class);
        return new ResponseUnmarshaller(context);
    }
}

