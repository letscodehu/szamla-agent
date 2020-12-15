package hu.letscode.billing.domain;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The complete billing request. To be serialized as XML.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@XmlRootElement(name = "xmlszamla")
public class BillingRequest {

    @JacksonXmlProperty(isAttribute = true)
    private final String xmlns = "http://www.szamlazz.hu/xmlszamla";

    @XmlElement(name = "beallitasok")
    private final Settings settings;

    @XmlElement(name = "fejlec")
    private final Header header;

    @XmlElement(name = "elado")
    private final Seller seller;

    @XmlElement(name = "vevo")
    private final Buyer buyer;

    @XmlElementWrapper(name = "tetelek")
    @XmlElement(name = "tetel")
    private final List<Item> items;

    public BillingRequest(final Settings settings, final Header header, final Seller seller, final Buyer buyer,
            final List<Item> items) {
        this.settings = settings;
        this.header = header;
        this.seller = seller;
        this.buyer = buyer;
        this.items = Collections.unmodifiableList(items);
    }

}
