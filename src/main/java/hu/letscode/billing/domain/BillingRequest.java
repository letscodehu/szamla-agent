package hu.letscode.billing.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The complete billing request. To be serialized as XML.
 */
@XmlRootElement(name = "xmlszamla")
public class BillingRequest {

    @XmlElement(name = "beallitasok")
    private Settings settings;

    @XmlElement(name = "fejlec")
    private Header header;

    @XmlElement(name = "elado")
    private Seller seller;

    @XmlElement(name = "vevo")
    private Buyer buyer;

    @XmlElementWrapper(name = "tetelek")
    @XmlElement(name = "tetel")
    private List<Item> items = new ArrayList<Item>();

    public BillingRequest setSettings(Settings settings) {
        this.settings = settings;
        return this;
    }

    public BillingRequest setHeader(Header header) {
        this.header = header;
        return this;
    }

    public BillingRequest setSeller(Seller seller) {
        this.seller = seller;
        return this;
    }

    public BillingRequest setBuyer(Buyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public BillingRequest setItems(List<Item> items) {
        this.items = items;
        return this;
    }
}
