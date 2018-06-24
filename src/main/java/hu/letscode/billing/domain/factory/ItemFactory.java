package hu.letscode.billing.domain.factory;

import hu.letscode.billing.domain.Item;
import hu.letscode.billing.domain.RawItem;
import hu.letscode.billing.domain.TaxCode;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * A factory to create {@link Item}'s from {@link RawItem}'s.
 */
public class ItemFactory {

    private final Map<TaxCode, BigDecimal> taxCodeMap = new HashMap<TaxCode, BigDecimal>() {{
        put(TaxCode.AAM, BigDecimal.ZERO);
        put(TaxCode.FIVE, BigDecimal.valueOf(5));
        put(TaxCode.EIGHTTEEN, BigDecimal.valueOf(18));
        put(TaxCode.NINETEEN, BigDecimal.valueOf(19));
        put(TaxCode.SEVEN, BigDecimal.valueOf(7));
        put(TaxCode.TWENTY, BigDecimal.valueOf(20));
        put(TaxCode.TWENTYFIVE, BigDecimal.valueOf(25));
        put(TaxCode.TWENTYSEVEN, BigDecimal.valueOf(27));
        // @TODO add the leftover taxcodes.
    }};

    public Item create(RawItem rawItem) {
        return create(rawItem.getName(), rawItem.getComment(), rawItem.getUnit(),
                rawItem.getNetUnitPrice(), rawItem.getAmount(), rawItem.getTaxCode());
    }


    public Item create(final String name, final String comment, final String unit, final BigDecimal netUnitPrice,
                       final BigDecimal amount, final TaxCode taxCode) {
        Item item = new Item();
        item.setTitle(name).setUnit(unit).setComment(comment).setTaxCode(taxCode).setNetUnitPrice(netUnitPrice).setAmount(amount);
        BigDecimal netTotal = netUnitPrice.multiply(amount);
        item.setNetTotal(netTotal);
        BigDecimal taxPercent = taxCodeMap.get(taxCode);
        if (taxPercent == null) {
            throw new IllegalArgumentException(String.format("%s not implemented yet!", taxCode.name()));
        }
        BigDecimal taxTotal = netTotal.multiply(taxPercent).multiply(BigDecimal.valueOf(100));
        item.setTaxTotal(taxTotal);
        item.setGrossTotal(netTotal.add(taxTotal));
        return item;
    }

}
