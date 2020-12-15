package hu.letscode.billing.domain;

import javax.xml.bind.annotation.XmlElement;

/**
 * Object containing information about the users' account which the client
 * operating on behalf. To be serialized as XML.
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class Settings {

    @XmlElement(name = "felhasznalo", required = false)
    private final String user;

    @XmlElement(name = "szamlaagentkulcs", required = false)
    private final String agentKey;

    @XmlElement(name = "jelszo", required = false)
    private final String password;

    @XmlElement(name = "eszamla", required = true)
    private final boolean electricBill;

    @XmlElement(name = "kulcstartojelszo", required = true)
    private final String keyChainPassword;

    @XmlElement(name = "szamlaLetoltes", required = true)
    private final boolean downloadBill;

    @XmlElement(name = "valaszVerzio", required = true)
    private final int answerType;

    public Settings(final String user, final String agentKey, final String password, final boolean electricBill,
            final String keyChainPassword, final boolean downloadBill, final int answerType) {
        this.user = user;
        this.agentKey = agentKey;
        this.password = password;
        this.electricBill = electricBill;
        this.keyChainPassword = keyChainPassword;
        this.downloadBill = downloadBill;
        this.answerType = answerType;
    }

}
