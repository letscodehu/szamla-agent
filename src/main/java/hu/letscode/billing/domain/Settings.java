package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Object containing information about the users' account which the client operating on behalf. To be serialized as XML.
 */
public class Settings {

    @XmlElement(name = "felhasznalo", required = true)
    private String user;

    @XmlElement(name = "jelszo", required = true)
    private String password;

    @XmlElement(name = "eszamla", required = true)
    private boolean eBill;

    @XmlElement(name = "kulcstartojelszo", required = true)
    private String keyChainPassword;

    @XmlElement(name = "szamlaLetoltes", required = true)
    private boolean downloadBill;

    @XmlElement(name = "valaszVerzio", required = true)
    private int answerType;

    public Settings setUser(String user) {
        this.user = user;
        return this;
    }

    public Settings setPassword(String password) {
        this.password = password;
        return this;
    }

    public Settings seteBill(boolean eBill) {
        this.eBill = eBill;
        return this;
    }

    public Settings setKeyChainPassword(String keyChainPassword) {
        this.keyChainPassword = keyChainPassword;
        return this;
    }

    public Settings setDownloadBill(boolean downloadBill) {
        this.downloadBill = downloadBill;
        return this;
    }

    public Settings setAnswerType(int answerType) {
        this.answerType = answerType;
        return this;
    }
}
