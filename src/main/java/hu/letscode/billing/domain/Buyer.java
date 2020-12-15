package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * The buyer of the product/service.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Buyer {

    @XmlElement(name = "nev")
    private final String name;
    @XmlElement(name = "irsz")
    private final String postalCode;
    @XmlElement(name = "telepules")
    private final String city;
    @XmlElement(name = "cim")
    private final String address;
    @XmlElement(name = "email")
    private final String email;
    @XmlElement(name = "sendEmail")
    private final boolean sendMail;
    @XmlElement(name = "adoszam")
    private final String taxNumber;
    @XmlElement(name = "postazasiNev")
    private final String mailingName;
    @XmlElement(name = "postazasiIrsz")
    private final String mailingPostalCode;
    @XmlElement(name = "postazasiTelepules")
    private final String mailingCity;
    @XmlElement(name = "postazasiCim")
    private final String mailingAddress;
    @XmlElement(name = "alairoNeve")
    private final String signatoryName;
    @XmlElement(name = "telefonszam")
    private final String phoneNumber;
    @XmlElement(name = "megjegyzes")
    private final String comment;

    public Buyer(String name, String postalCode, String city, String address, String email, boolean sendMail,
            String taxNumber, String mailingName, String mailingPostalCode, String mailingCity, String mailingAddress,
            String signatoryName, String phoneNumber, String comment) {
        this.name = name;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.email = email;
        this.sendMail = sendMail;
        this.taxNumber = taxNumber;
        this.mailingName = mailingName;
        this.mailingPostalCode = mailingPostalCode;
        this.mailingCity = mailingCity;
        this.mailingAddress = mailingAddress;
        this.signatoryName = signatoryName;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

}
