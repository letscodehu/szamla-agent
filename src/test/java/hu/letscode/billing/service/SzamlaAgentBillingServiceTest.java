package hu.letscode.billing.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.XmlField;
import hu.letscode.billing.domain.BillingCreateResponse;
import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import hu.letscode.billing.domain.marshaller.ResponseUnmarshaller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.xml.bind.JAXBException;

/**
 * @author Krisztian_Papp Test class for {@link SzamlaAgentBillingServiceTest}.
 */

@RunWith(MockitoJUnitRunner.class)
public class SzamlaAgentBillingServiceTest {

    @Rule
    public ExpectedException expected = ExpectedException.none();
    @Mock
    private Seller seller;
    @Mock
    private Settings settings;

    @Mock
    private BillingRequest billingRequest;

    @Mock
    private SzamlaAgentClient szamlaAgentClient;

    @Mock
    private ResponseUnmarshaller responseUnmarshaller;
    @Mock
    private RequestMarshaller requestMarshaller;

    @InjectMocks
    private SzamlaAgentBillingService underTest;

    @Test
    public void createBillShouldReturnResponseWhenNothingWentWrong() throws JAXBException {
        // GIVEN
        byte[] mockContent = new byte[5];
        when(requestMarshaller.createXmlContent(billingRequest)).thenReturn(mockContent);
        when(responseUnmarshaller.marshallResponse(Mockito.any(), Mockito.any()))
                .thenReturn(new BillingCreateResponse());
        // WHEN
        BillingCreateResponse actual = underTest.createBill(billingRequest);
        // THEN
        verify(billingRequest).setSettings(settings);
        verify(billingRequest).setSeller(seller);
        verify(requestMarshaller).createXmlContent(billingRequest);
        verify(szamlaAgentClient).execute(XmlField.CREATE_BILL, mockContent);
        verifyNoMoreInteractions(requestMarshaller, szamlaAgentClient, billingRequest);
        assertNotNull(actual);
    }

    @Test
    public void createBillShouldReturnFalseWhenExceptionOccured() throws JAXBException {
        // GIVEN
        expected.expect(RuntimeException.class);
        when(requestMarshaller.createXmlContent(billingRequest))
                .thenThrow(new JAXBException("I " + "am your father Luke"));
        // WHEN
        BillingCreateResponse actual = underTest.createBill(billingRequest);
        // THEN exception is thrown
    }

}
