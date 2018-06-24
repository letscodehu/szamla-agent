package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * The buyer of the product/service.
 */
public class Buyer {

    @XmlElement(name = "nev")
    private String name;
    @XmlElement(name = "irsz")
    private String postalCode;
    @XmlElement(name = "telepules")
    private String city;
    @XmlElement(name = "cim")
    private String address;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "sendEmail")
    private boolean sendMail;
    @XmlElement(name = "adoszam")
    private String taxNumber;
    @XmlElement(name = "postazasiNev")
    private String mailingName;
    @XmlElement(name = "postazasiIrsz")
    private String mailingPostalCode;
    @XmlElement(name = "postazasiTelepules")
    private String mailingCity;
    @XmlElement(name = "postazasiCim")
    private String mailingAddress;
    @XmlElement(name = "alairoNeve")
    private String signatoryName;
    @XmlElement(name = "telefonszam")
    private String phoneNumber;
    @XmlElement(name = "megjegyzes")
    private String comment;

    public Buyer setName(String name) {
        this.name = name;
        return this;
    }

    public Buyer setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Buyer setCity(String city) {
        this.city = city;
        return this;
    }

    public Buyer setAddress(String address) {
        this.address = address;
        return this;
    }

    public Buyer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Buyer setSendMail(boolean sendMail) {
        this.sendMail = sendMail;
        return this;
    }

    public Buyer setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public Buyer setMailingName(String mailingName) {
        this.mailingName = mailingName;
        return this;
    }

    public Buyer setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
        return this;
    }

    public Buyer setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
        return this;
    }

    public Buyer setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
        return this;
    }

    public Buyer setSignatoryName(String signatoryName) {
        this.signatoryName = signatoryName;
        return this;
    }

    public Buyer setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Buyer setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
