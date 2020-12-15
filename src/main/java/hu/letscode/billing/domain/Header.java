package hu.letscode.billing.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import hu.letscode.billing.domain.serializer.LanguageSerializer;

/**
 * The bills header.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Header {

    @JacksonXmlProperty(localName = "keltDatum")
    private final LocalDate leavenedDate;

    @JacksonXmlProperty(localName = "teljesitesDatum")
    private final LocalDate fulfillmentDate;

    @JacksonXmlProperty(localName = "fizetesiHataridoDatum")
    private final LocalDate deadlineDate;

    @JacksonXmlProperty(localName = "fizmod")
    private final String paymentType;
    @JacksonXmlProperty(localName = "penznem")
    private final Currency currency;
    @JsonSerialize(using = LanguageSerializer.class)
    @JacksonXmlProperty(localName = "szamlaNyelve")
    private final Language language;
    @JacksonXmlProperty(localName = "megjegyzes")
    private final String comment;
    @JacksonXmlProperty(localName = "arfolyamBank")
    private final String exchangeBank;
    @JacksonXmlProperty(localName = "arfolyam")
    private final BigDecimal exchangeRate;
    @JacksonXmlProperty(localName = "rendelesSzam")
    private final String orderNumber;
    @JacksonXmlProperty(localName = "elolegszamla")
    private final boolean imprestBill;
    @JacksonXmlProperty(localName = "vegszamla")
    private final boolean finalBill;
    @JacksonXmlProperty(localName = "helyesbitoszamla")
    private final boolean correctionBill;
    @JacksonXmlProperty(localName = "helyesbitettSzamla")
    private final String correctedBillNumber;
    @JacksonXmlProperty(localName = "dijbekero")
    private final boolean prepaymentRequest;
    @JacksonXmlProperty(localName = "szamlaszamElotag")
    private final String orderNumberPrefix;
    @JacksonXmlProperty(localName = "fizetve")
    private final boolean paidAlready;

    @SuppressWarnings("ParameterNumber")
    public Header(LocalDate leavenedDate, LocalDate fulfillmentDate, LocalDate deadlineDate, String paymentType,
            Currency currency, Language language, String comment, String exchangeBank, BigDecimal exchangeRate,
            String orderNumber, boolean imprestBill, boolean finalBill, boolean correctionBill,
            String correctedBillNumber, boolean prepaymentRequest, String orderNumberPrefix, boolean paidAlready) {
        this.leavenedDate = leavenedDate;
        this.fulfillmentDate = fulfillmentDate;
        this.deadlineDate = deadlineDate;
        this.paymentType = paymentType;
        this.currency = currency;
        this.language = language;
        this.comment = comment;
        this.exchangeBank = exchangeBank;
        this.exchangeRate = exchangeRate;
        this.orderNumber = orderNumber;
        this.imprestBill = imprestBill;
        this.finalBill = finalBill;
        this.correctionBill = correctionBill;
        this.correctedBillNumber = correctedBillNumber;
        this.prepaymentRequest = prepaymentRequest;
        this.orderNumberPrefix = orderNumberPrefix;
        this.paidAlready = paidAlready;
    }

}
