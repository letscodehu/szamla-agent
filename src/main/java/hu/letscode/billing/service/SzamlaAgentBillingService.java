package hu.letscode.billing.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.XmlField;
import hu.letscode.billing.domain.*; // NOPMD

/**
 * The concrete billing service. Clients should use this class only.
 * 
 * @author tacsiazuma
 */
public class SzamlaAgentBillingService implements BillingService {

    private final SzamlaAgentClient szamlaAgentClient;
    private final Seller seller;
    private final Settings settings;
    private final XmlMapper xmlMapper;

    /**
     * Constructor.
     * 
     * @param szamlaAgentClient the client
     * @param seller            the seller
     * @param settings          the settings
     */
    public SzamlaAgentBillingService(final SzamlaAgentClient szamlaAgentClient,
                                     final Seller seller, final Settings settings, final XmlMapper xmlMapper
                                     ) {
        this.szamlaAgentClient = szamlaAgentClient;
        this.seller = seller;
        this.settings = settings;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public BillingCreateResponse createBill(final BillingRequest billingRequest) {
        try {
            final BillingRequest request = transformRequest(billingRequest);
            final byte[] content = xmlMapper.writeValueAsBytes(request);
            return xmlMapper.readValue(szamlaAgentClient.execute(XmlField.CREATE_BILL, content),
                    BillingCreateResponse.class);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BillingRequest transformRequest(final BillingRequest billingRequest) {
        billingRequest.setSeller(seller);
        billingRequest.setSettings(settings);
        return billingRequest;
    }

    @Override
    public BillingRevokeResponse revokeBill(final BillRevokeRequest billRevokeRequest) {
        try {
            final byte[] content = xmlMapper.writeValueAsBytes(billRevokeRequest);
            return xmlMapper.readValue(szamlaAgentClient.execute(XmlField.STORNO_BILL, content),
                    BillingRevokeResponse.class);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
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
