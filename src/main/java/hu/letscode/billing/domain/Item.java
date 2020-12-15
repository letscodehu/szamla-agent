package hu.letscode.billing.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An item on the bills' itemlist.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@XmlRootElement
public class Item {

    @XmlElement(name = "megnevezes", required = true)
    private final String title;
    @XmlElement(name = "mennyiseg", required = true)
    private final BigDecimal amount;
    @XmlElement(name = "mennyisegiEgyseg", required = true)
    private final String unit;
    @XmlElement(name = "nettoEgysegar", required = true)
    private final BigDecimal netUnitPrice;
    @XmlElement(name = "afakulcs", required = true)
    private final TaxCode taxCode;
    @XmlElement(name = "nettoErtek", required = true)
    private final BigDecimal netTotal;
    @XmlElement(name = "afaErtek", required = true)
    private final BigDecimal taxTotal;
    @XmlElement(name = "bruttoErtek", required = true)
    private final BigDecimal grossTotal;
    @XmlElement(name = "megjegyzes", required = true)
    private final String comment;

    public Item(String title, BigDecimal amount, String unit, BigDecimal netUnitPrice, TaxCode taxCode,
            BigDecimal netTotal, BigDecimal taxTotal, BigDecimal grossTotal, String comment) {
        this.title = title;
        this.amount = amount;
        this.unit = unit;
        this.netUnitPrice = netUnitPrice;
        this.taxCode = taxCode;
        this.netTotal = netTotal;
        this.taxTotal = taxTotal;
        this.grossTotal = grossTotal;
        this.comment = comment;
    }

}
