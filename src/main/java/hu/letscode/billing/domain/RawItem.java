package hu.letscode.billing.domain;

import java.math.BigDecimal;

/**
 * An incoming DTO which will be transformed to item.
 */
public class RawItem {

    private final String name;
    private final String comment;
    private final BigDecimal netUnitPrice;
    private final String unit;
    private final TaxCode taxCode;
    private final BigDecimal amount;

    /**
     * Default constructor.
     * @param name the item's name
     * @param comment comment
     * @param unit the unit
     * @param netUnitPrice the NET unit price of the item
     * @param amount the price to be payed
     * @param taxCode the tax code
     */
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
