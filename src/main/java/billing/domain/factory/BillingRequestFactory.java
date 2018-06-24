package billing.domain.factory;

import billing.domain.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tacsiazuma on 2017.05.30..
 */
public class BillingRequestFactory {

    private final ItemFactory itemFactory;

    public BillingRequestFactory(ItemFactory itemFactory) {
        this.itemFactory = itemFactory;
    }

    public BillingRequest create(Buyer buyer, List<RawItem> billableItems, Header header) {
        List<Item> items = billableItems.stream().map(itemFactory::create).collect(Collectors.toList());
        BillingRequest billingRequest = new BillingRequest();
        billingRequest.setHeader(header);
        billingRequest.setItems(items);
        billingRequest.setBuyer(buyer);
        return billingRequest;
    }
}
