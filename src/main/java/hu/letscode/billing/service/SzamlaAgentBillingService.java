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
    private final XmlMapper xmlMapper;

    /**
     * Constructor.
     * 
     * @param szamlaAgentClient the client
     * @param xmlMapper         the xml mapper
     */
    public SzamlaAgentBillingService(final SzamlaAgentClient szamlaAgentClient, final XmlMapper xmlMapper) {
        this.szamlaAgentClient = szamlaAgentClient;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public BillingCreateResponse createBill(final BillingRequest billingRequest) {
        try {
            final byte[] content = xmlMapper.writeValueAsBytes(billingRequest);
            return xmlMapper.readValue(szamlaAgentClient.execute(XmlField.CREATE_BILL, content),
                    BillingCreateResponse.class);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
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
