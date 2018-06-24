package hu.letscode.billing.domain;

import java.math.BigDecimal;

/**
 * An incoming DTO which will be transformed to item.
 */
public class RawItem {

    private String name;
    private String comment;
    private BigDecimal netUnitPrice;
    private String unit;
    private TaxCode taxCode;
    private BigDecimal amount;

    public RawItem(String name, String comment, BigDecimal netUnitPrice, String unit, TaxCode taxCode,
                   BigDecimal amount) {
        this.name = name;
        this.comment = comment;
        this.netUnitPrice = netUnitPrice;
        this.unit = unit;
        this.taxCode = taxCode;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public BigDecimal getNetUnitPrice() {
        return netUnitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public TaxCode getTaxCode() {
        return taxCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
