package billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by tacsiazuma on 2017.05.07..
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
