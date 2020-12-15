package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Object containing information about the seller of the item/service. To be
 * serialized as XML.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Seller {

    @XmlElement(name = "bank")
    private final String bankName;
    @XmlElement(name = "bankszamlaszam")
    private final String accountNumber;
    @XmlElement(name = "emailReplyto")
    private final String emailReplyTo;
    @XmlElement(name = "emailTargy")
    private final String emailSubject;
    @XmlElement(name = "emailSzoveg")
    private final String emailContent;
    @XmlElement(name = "alairoNeve")
    private final String sellerSignatory;

    public Seller(String bankName, String accountNumber, String emailReplyTo, String emailSubject, String emailContent,
            String sellerSignatory) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.emailReplyTo = emailReplyTo;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
        this.sellerSignatory = sellerSignatory;
    }

}
