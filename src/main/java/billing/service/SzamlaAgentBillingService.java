package billing.service;

import billing.client.SzamlaAgentClient;
import billing.client.XmlField;
import billing.domain.BillingRequest;
import billing.domain.Seller;
import billing.domain.Settings;
import billing.domain.marshaller.RequestMarshaller;

import javax.xml.bind.JAXBException;

/**
 * The concrete billing service. Clients should use this class only.
 * @author tacsiazuma
 */
public class SzamlaAgentBillingService implements BillingService {

    private final SzamlaAgentClient szamlaAgentClient;
    private final RequestMarshaller requestMarshaller;
    private final Seller seller;
    private final Settings settings;

    /**
     * Constructor.
     * @param szamlaAgentClient the client
     * @param requestMarshaller the request marshaller
     * @param seller the seller
     * @param settings the settings
     */
    public SzamlaAgentBillingService(SzamlaAgentClient szamlaAgentClient, RequestMarshaller requestMarshaller, Seller seller, Settings settings) {
        this.szamlaAgentClient = szamlaAgentClient;
        this.requestMarshaller = requestMarshaller;
        this.seller = seller;
        this.settings = settings;
    }

    public boolean createBill(BillingRequest billingRequest) {
        boolean success = false;
        try {
            BillingRequest request = transformRequest(billingRequest);
            byte[] content = requestMarshaller.createXmlContent(request);
            szamlaAgentClient.execute(XmlField.CREATE_BILL, content);
            success = true;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return success;
    }

    private BillingRequest transformRequest(BillingRequest billingRequest) {
        billingRequest.setSeller(seller);
        billingRequest.setSettings(settings);
        return billingRequest;
    }

    public boolean revokeBill(BillingRequest billingRequest) {
        return false;
    }

    public boolean markFulfilled(BillingRequest billingRequest) {
        return false;
    }

    public boolean retreivePdf(BillingRequest billingRequest) {
        return false;
    }
}
