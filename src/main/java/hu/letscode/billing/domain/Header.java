package hu.letscode.billing.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import hu.letscode.billing.domain.serializer.LanguageSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;


/**
 * The bills header.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Header {

    @JacksonXmlProperty(localName = "keltDatum")
    private LocalDate leavenedDate;

    @JacksonXmlProperty(localName = "teljesitesDatum")
    private LocalDate fulfillmentDate;

    @JacksonXmlProperty(localName = "fizetesiHataridoDatum")
    private LocalDate deadlineDate;

    @JacksonXmlProperty(localName = "fizmod")
    private String paymentType;
    @JacksonXmlProperty(localName = "penznem")
    private Currency currency;
    @JsonSerialize(using = LanguageSerializer.class)
    @JacksonXmlProperty(localName = "szamlaNyelve")
    private Language language;
    @JacksonXmlProperty(localName = "megjegyzes")
    private String comment;
    @JacksonXmlProperty(localName = "arfolyamBank")
    private String exchangeBank;
    @JacksonXmlProperty(localName = "arfolyam")
    private BigDecimal exchangeRate;
    @JacksonXmlProperty(localName = "rendelesSzam")
    private String orderNumber;
    @JacksonXmlProperty(localName = "elolegszamla")
    private boolean imprestBill;
    @JacksonXmlProperty(localName = "vegszamla")
    private boolean finalBill;
    @JacksonXmlProperty(localName = "helyesbitoszamla")
    private boolean correctionBill;
    @JacksonXmlProperty(localName = "helyesbitettSzamla")
    private String correctedBillNumber;
    @JacksonXmlProperty(localName = "dijbekero")
    private boolean prepaymentRequest;
    @JacksonXmlProperty(localName = "szamlaszamElotag")
    private String orderNumberPrefix;
    @JacksonXmlProperty(localName = "fizetve")
    private boolean paidAlready;

    public Header setLeavenedDate(LocalDateTime leavenedDate) {
        this.leavenedDate = leavenedDate.toLocalDate();
        return this;
    }

    public Header setFulfillmentDate(LocalDateTime fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate.toLocalDate();
        return this;
    }

    public Header setDeadlineDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate.toLocalDate();
        return this;
    }

    public Header setPaymentType(String paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public Header setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Header setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public Header setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Header setExchangeBank(String exchangeBank) {
        this.exchangeBank = exchangeBank;
        return this;
    }

    public Header setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
        return this;
    }

    public Header setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public Header setImprestBill(boolean imprestBill) {
        this.imprestBill = imprestBill;
        return this;
    }

    public Header setFinalBill(boolean finalBill) {
        this.finalBill = finalBill;
        return this;
    }

    public Header setCorrectionBill(boolean correctionBill) {
        this.correctionBill = correctionBill;
        return this;
    }

    public Header setPrepaymentRequest(boolean prepaymentRequest) {
        this.prepaymentRequest = prepaymentRequest;
        return this;
    }

    public Header setOrderNumberPrefix(String orderNumberPrefix) {
        this.orderNumberPrefix = orderNumberPrefix;
        return this;
    }

    public Header setPaidAlready(boolean paidAlready) {
        this.paidAlready = paidAlready;
        return this;
    }

    public Header setCorrectedBillNumber(String correctedBillNumber) {
        this.correctedBillNumber = correctedBillNumber;
        return this;
    }


}
