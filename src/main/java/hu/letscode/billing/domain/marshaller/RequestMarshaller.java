package hu.letscode.billing.domain.marshaller;

import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.factory.StringWriterFactory;

/**
 * Marshaller class for creating XML from the {@link BillingRequest}.
 * @author tacsiazuma
 */
public class RequestMarshaller {

    private static final String XSD_LOCATION = "http://www.szamlazz.hu/xmlszamla xmlszamla.xsd";

    private final JAXBContext jaxbContext;
    private final StringWriterFactory stringWriterFactory;

    /**
     * Constructor.
     * @param jaxbContext {@link JAXBContext} used to create new {@link Marshaller}.
     * @param stringWriterFactory {@link StringWriterFactory} used to create new {@link StringWriter}.
     */
    public RequestMarshaller(JAXBContext jaxbContext, StringWriterFactory stringWriterFactory) {
        this.jaxbContext = jaxbContext;
        this.stringWriterFactory = stringWriterFactory;
    }

    /**
     * Marshalls the given request into an XML byte array.
     * @param billingRequest the request
     * @return the byte array after marshalling
     * @throws JAXBException if any marshalling issue happens
     */
    public byte[] createXmlContent(BillingRequest billingRequest) throws JAXBException {
        StringWriter writer = stringWriterFactory.create();
        Marshaller marshaller = getMarshaller();
        marshaller.marshal(billingRequest, writer);
        return writer.toString().getBytes(StandardCharsets.UTF_8);
    }

    private Marshaller getMarshaller() throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XSD_LOCATION);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return marshaller;
    }

}
