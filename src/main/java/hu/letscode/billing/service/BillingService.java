package hu.letscode.billing.service;

import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.BillRevokeRequest;
import hu.letscode.billing.domain.BillingCreateResponse;
import hu.letscode.billing.domain.BillingRevokeResponse;

/**
 * Created by tacsiazuma on 2017.03.11..
 */
public interface BillingService {

    /**
     * Creates a new invoice.
     * @param billingRequest the billing request.
     * @return if successful.
     */
    BillingCreateResponse createBill(BillingRequest billingRequest);

    /**
     * Revokes an invoice.
     * @param billRevokeRequest the billing request.
     * @return if successful.
     */
    BillingRevokeResponse revokeBill(BillRevokeRequest billRevokeRequest);

    /**
     * Mark an invoice fulfilled.
     * @param billingRequest the billing request.
     * @return if successful.
     */
    boolean markFulfilled(BillingRequest billingRequest);

    /**
     * Retrieves a PDF version of an invoice.
     * @param billingRequest the billing request.
     * @return if successful.
     */
    boolean retreivePdf(BillingRequest billingRequest);

}
