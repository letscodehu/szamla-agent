package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Object containing information about the users' account which the client operating on behalf. To be serialized as XML.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Settings {

    @XmlElement(name = "felhasznalo", required = false)
    private String user;

    @XmlElement(name = "szamlaagentkulcs", required = false)
    private String agentKey;

    @XmlElement(name = "jelszo", required = false)
    private String password;

    @XmlElement(name = "eszamla", required = true)
    private boolean electricBill;

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

    public Settings seteBill(boolean electricBill) {
        this.electricBill = electricBill;
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

    public Settings setAgentKey(String agentKey) {
        this.agentKey = agentKey;
        return this;
    }
}
