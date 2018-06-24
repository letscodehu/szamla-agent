package hu.letscode.billing.domain;

import hu.letscode.billing.domain.marshaller.LanguageTypeAdapter;
import hu.letscode.billing.domain.marshaller.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

/**
 * The bills header.
 */
public class Header {

    @XmlElement(name = "keltDatum", required = true)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime leavenedDate;

    @XmlElement(name = "teljesitesDatum", required = true)
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDateTime fulfillmentDate;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name = "fizetesiHataridoDatum", required = true)
    private LocalDateTime deadlineDate;

    @XmlElement(name = "fizmod", required = true)
    private String paymentType;
    @XmlElement(name = "penznem", required = true)
    private Currency currency;

    @XmlJavaTypeAdapter(LanguageTypeAdapter.class)
    @XmlElement(name = "szamlaNyelve", required = true)
    private Language language;
    @XmlElement(name = "megjegyzes", required = true)
    private String comment;
    @XmlElement(name = "arfolyamBank", required = true)
    private String exchangeBank;
    @XmlElement(name = "arfolyam", required = true)
    private BigDecimal exchangeRate;
    @XmlElement(name = "rendelesSzam", required = true)
    private String orderNumber;
    @XmlElement(name = "elolegszamla", required = true)
    private boolean imprestBill;
    @XmlElement(name = "vegszamla", required = true)
    private boolean finalBill;
    @XmlElement(name = "helyesbitoszamla", required = true)
    private boolean correctionBill;
    @XmlElement(name = "helyesbitettSzamla", required = true)
    private String correctedBillNumber;
    @XmlElement(name = "dijbekero", required = true)
    private boolean prepaymentRequest;
    @XmlElement(name = "szamlaszamElotag", required = true)
    private String orderNumberPrefix;
    @XmlElement(name = "fizetve", required = true)
    private boolean paidAlready;

    public Header setLeavenedDate(LocalDateTime leavenedDate) {
        this.leavenedDate = leavenedDate;
        return this;
    }

    public Header setFulfillmentDate(LocalDateTime fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
        return this;
    }

    public Header setDeadlineDate(LocalDateTime deadlineDate) {
        this.deadlineDate = deadlineDate;
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
