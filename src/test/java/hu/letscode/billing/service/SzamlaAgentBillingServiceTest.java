package hu.letscode.billing.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.XmlField;
import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;

import javax.xml.bind.JAXBException;

/**
 * @author Krisztian_Papp
 * Test class for {@link SzamlaAgentBillingServiceTest}.
 */

@RunWith(MockitoJUnitRunner.class)
public class SzamlaAgentBillingServiceTest {


    @Mock
    private Seller seller;
    @Mock
    private Settings settings;

    @Mock
    private BillingRequest billingRequest;

    @Mock
    private SzamlaAgentClient szamlaAgentClient;

    @Mock
    private RequestMarshaller requestMarshaller;

    @InjectMocks
    private SzamlaAgentBillingService underTest;

    @Test
    public void createBillShouldReturnTrueWhenNothingWentWrong() throws JAXBException {
        // GIVEN
        byte[] mockContent = new byte[5];

        when(requestMarshaller.createXmlContent(billingRequest)).thenReturn(mockContent);
        // WHEN
        boolean actual = underTest.createBill(billingRequest);
        // THEN
        verify(billingRequest).setSettings(settings);
        verify(billingRequest).setSeller(seller);
        verify(requestMarshaller).createXmlContent(billingRequest);
        verify(szamlaAgentClient).execute(XmlField.CREATE_BILL, mockContent);
        verifyNoMoreInteractions(requestMarshaller, szamlaAgentClient, billingRequest);
        assertTrue(actual);
    }

    @Test
    public void createBillShouldReturnFalseWhenExceptionOccured() throws JAXBException {
        // GIVEN
        when(requestMarshaller.createXmlContent(billingRequest)).thenThrow(new JAXBException("I " +
                "am your father Luke"));
        // WHEN
        boolean actual = underTest.createBill(billingRequest);
        // THEN
        verify(billingRequest).setSettings(settings);
        verify(billingRequest).setSeller(seller);
        verify(requestMarshaller).createXmlContent(billingRequest);
        verifyNoMoreInteractions(requestMarshaller, szamlaAgentClient, billingRequest);
        assertFalse(actual);
    }

}