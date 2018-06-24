package billing.domain;

import billing.domain.factory.StringWriterFactory;
import billing.domain.marshaller.RequestMarshaller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestMarshallerTest {

    private static final String XSD_LOCATION = "http://www.szamlazz.hu/xmlszamla xmlszamla.xsd";

    private RequestMarshaller underTest;

    @Mock
    private JAXBContext mockContext;
    @Mock
    private Marshaller mockMarshaller;
    @Mock
    private StringWriterFactory mockStringWriterFactory;
    @Mock
    private StringWriter mockStringWriter;

    @Before
    public void setUp() {
        underTest = new RequestMarshaller(mockContext, mockStringWriterFactory);
    }

    @Test
    public void createXmlContentShouldReturnByteArray() throws JAXBException {
        // GIVEN
        when(mockContext.createMarshaller()).thenReturn(mockMarshaller);
        when(mockStringWriterFactory.create()).thenReturn(mockStringWriter);
        when(mockStringWriter.toString()).thenReturn("test");
        BillingRequest billingRequest = new BillingRequest();
        // WHEN
        byte[] actual = underTest.createXmlContent(billingRequest);
        // THEN
        assertEquals("test", new String(actual));
        verify(mockContext).createMarshaller();
        verify(mockStringWriterFactory).create();
        verify(mockMarshaller).marshal(billingRequest, mockStringWriter);
        verify(mockMarshaller).setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        verify(mockMarshaller).setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XSD_LOCATION);
        verifyNoMoreInteractions(mockContext, mockMarshaller, mockStringWriterFactory);
    }
}