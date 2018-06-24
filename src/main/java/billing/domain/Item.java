package billing.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
@XmlRootElement
public class Item {

    @XmlElement(name = "megnevezes", required = true)
    private String title;
    @XmlElement(name = "mennyiseg", required = true)
    private BigDecimal amount;
    @XmlElement(name = "mennyisegiEgyseg", required = true)
    private String unit;
    @XmlElement(name = "nettoEgysegar", required = true)
    private BigDecimal netUnitPrice;
    @XmlElement(name = "afakulcs", required = true)
    private TaxCode taxCode;
    @XmlElement(name = "nettoErtek", required = true)
    private BigDecimal netTotal;
    @XmlElement(name = "afaErtek", required = true)
    private BigDecimal taxTotal;
    @XmlElement(name = "bruttoErtek", required = true)
    private BigDecimal grossTotal;
    @XmlElement(name = "megjegyzes", required = true)
    private String comment;

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public Item setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public Item setUnit(String unit) {
        this.unit = unit;
        return this;
    }

    public Item setNetUnitPrice(BigDecimal netUnitPrice) {
        this.netUnitPrice = netUnitPrice;
        return this;
    }

    public Item setTaxCode(TaxCode taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    public Item setNetTotal(BigDecimal netTotal) {
        this.netTotal = netTotal;
        return this;
    }

    public Item setTaxTotal(BigDecimal taxTotal) {
        this.taxTotal = taxTotal;
        return this;
    }

    public Item setGrossTotal(BigDecimal grossTotal) {
        this.grossTotal = grossTotal;
        return this;
    }

    public Item setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
