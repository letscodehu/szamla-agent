package hu.letscode.billing.service;

import hu.letscode.billing.domain.BillingRequest;

/**
 * Created by tacsiazuma on 2017.03.11..
 */
public interface BillingService {

    /**
     * Creates a new invoice.
     * @param billingRequest the billing request.
     * @return if successful.
     */
    boolean createBill(BillingRequest billingRequest);

    /**
     * Revokes an invoice.
     * @param billingRequest the billing request.
     * @return if successful.
     */
    boolean revokeBill(BillingRequest billingRequest);

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
