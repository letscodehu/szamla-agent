package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Object containing information about the seller of the item/service. To be serialized as XML.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Seller {

    @XmlElement(name = "bank")
    private String bankName;
    @XmlElement(name = "bankszamlaszam")
    private String accountNumber;
    @XmlElement(name = "emailReplyto")
    private String emailReplyTo;
    @XmlElement(name = "emailTargy")
    private String emailSubject;
    @XmlElement(name = "emailSzoveg")
    private String emailContent;
    @XmlElement(name = "alairoNeve")
    private String sellerSignatory;

    public Seller setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public Seller setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public Seller setEmailReplyTo(String emailReplyTo) {
        this.emailReplyTo = emailReplyTo;
        return this;
    }

    public Seller setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
        return this;
    }

    public Seller setEmailContent(String emailContent) {
        this.emailContent = emailContent;
        return this;
    }

    public Seller setSellerSignatory(String sellerSignatory) {
        this.sellerSignatory = sellerSignatory;
        return this;
    }
}
