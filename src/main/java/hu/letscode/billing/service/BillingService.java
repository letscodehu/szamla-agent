package hu.letscode.billing.service;

import hu.letscode.billing.domain.BillingRequest;

/**
 * Created by tacsiazuma on 2017.03.11..
 */
public interface BillingService {

    boolean createBill(BillingRequest billingRequest);
    boolean revokeBill(BillingRequest billingRequest);
    boolean markFulfilled(BillingRequest billingRequest);
    boolean retreivePdf(BillingRequest billingRequest);

}
