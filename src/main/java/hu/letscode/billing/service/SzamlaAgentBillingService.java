package hu.letscode.billing.service;

import java.io.InputStream;

import javax.xml.bind.JAXBException;

import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.XmlField;
import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.BillingCreateResponse;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import hu.letscode.billing.domain.marshaller.ResponseUnmarshaller;

/**
 * The concrete billing service. Clients should use this class only.
 * 
 * @author tacsiazuma
 */
public class SzamlaAgentBillingService implements BillingService {

    private final SzamlaAgentClient szamlaAgentClient;
    private final RequestMarshaller requestMarshaller;
    private final ResponseUnmarshaller responseUnmarshaller;
    private final Seller seller;
    private final Settings settings;

    /**
     * Constructor.
     * 
     * @param szamlaAgentClient the client
     * @param requestMarshaller the request marshaller
     * @param seller            the seller
     * @param settings          the settings
     */
    public SzamlaAgentBillingService(final SzamlaAgentClient szamlaAgentClient,
            final RequestMarshaller requestMarshaller, final Seller seller, final Settings settings,
            final ResponseUnmarshaller responseMarshaller) {
        this.responseUnmarshaller = responseMarshaller;
        this.szamlaAgentClient = szamlaAgentClient;
        this.requestMarshaller = requestMarshaller;
        this.seller = seller;
        this.settings = settings;
    }

    @Override
    public BillingCreateResponse createBill(final BillingRequest billingRequest) {
        try {
            final BillingRequest request = transformRequest(billingRequest);
            final byte[] content = requestMarshaller.createXmlContent(request);
            BillingCreateResponse response = transormResponse(szamlaAgentClient.execute(XmlField.CREATE_BILL, content),
                    BillingCreateResponse.class);
            return response;
        } catch (final JAXBException e) {
            throw new RuntimeException(e);
        }

    }

    private BillingRequest transformRequest(final BillingRequest billingRequest) {
        billingRequest.setSeller(seller);
        billingRequest.setSettings(settings);
        return billingRequest;
    }

    private <T> T transormResponse(final InputStream stream, final Class<T> type) throws JAXBException {
        return responseUnmarshaller.marshallResponse(stream, type);
    }

    @Override
    public boolean revokeBill(final BillingRequest billingRequest) {
        return false;
    }

    @Override
    public boolean markFulfilled(final BillingRequest billingRequest) {
        return false;
    }

    @Override
    public boolean retreivePdf(final BillingRequest billingRequest) {
        return false;
    }
}
