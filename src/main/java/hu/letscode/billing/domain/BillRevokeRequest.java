package hu.letscode.billing.domain;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;

@JacksonXmlRootElement(localName = "xmlszamlast")
public class BillRevokeRequest {

    @SuppressWarnings("PMD.UnusedPrivateField")
    @JacksonXmlProperty(isAttribute = true)
    private final String xmlns = "http://www.szamlazz.hu/xmlszamlast";

    @JacksonXmlProperty(localName = "beallitasok")
    private RevokeSettings settings;
    @JacksonXmlProperty(localName = "fejlec")
    private RevokeHeader header;
    @JacksonXmlProperty(localName = "elado")
    private RevokeSeller seller;
    @JacksonXmlProperty(localName = "vevo")
    private RevokeBuyer buyer;

    public static class RevokeSettings {
        @JacksonXmlProperty(localName = "felhasznalo")
        private String username;
        @JacksonXmlProperty(localName = "jelszo")
        private String password;
        @JacksonXmlProperty(localName = "szamlaagentkulcs")
        private String agentKey;
        @JacksonXmlProperty(localName = "eszamla")
        private boolean eBill;
        @JacksonXmlProperty(localName = "szamlaLetoltes")
        private boolean downloadBill;
        @JacksonXmlProperty(localName = "szamlaLetoltesPld")
        private int downloadBillOriginal;
        @JacksonXmlProperty(localName = "valaszVerzio")
        private int answerType;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAgentKey() {
            return agentKey;
        }

        public void setAgentKey(String agentKey) {
            this.agentKey = agentKey;
        }

        public boolean geteBill() {
            return eBill;
        }

        public void seteBill(boolean eBill) {
            this.eBill = eBill;
        }

        public boolean isDownloadBill() {
            return downloadBill;
        }

        public void setDownloadBill(boolean downloadBill) {
            this.downloadBill = downloadBill;
        }

        public int getDownloadBillOriginal() {
            return downloadBillOriginal;
        }

        public void setDownloadBillOriginal(int downloadBillOriginal) {
            this.downloadBillOriginal = downloadBillOriginal;
        }

        public int getAnswerType() {
            return answerType;
        }

        public void setAnswerType(int answerType) {
            this.answerType = answerType;
        }
    }

    public static class RevokeSeller {
        @JacksonXmlProperty(localName = "emailReplyto")
        private String emailReplyTo;
        @JacksonXmlProperty(localName = "emailTargy")
        private String emailSubject;
        @JacksonXmlProperty(localName = "emailSzoveg")
        private String emailText;

        public String getEmailReplyTo() {
            return emailReplyTo;
        }

        public void setEmailReplyTo(String emailReplyTo) {
            this.emailReplyTo = emailReplyTo;
        }

        public String getEmailSubject() {
            return emailSubject;
        }

        public void setEmailSubject(String emailSubject) {
            this.emailSubject = emailSubject;
        }

        public String getEmailText() {
            return emailText;
        }

        public void setEmailText(String emailText) {
            this.emailText = emailText;
        }
    }

    public static class RevokeBuyer {
        @JacksonXmlProperty(localName = "email")
        private String email;
        @JacksonXmlProperty(localName = "adoszam")
        private String taxNumber;
        @JacksonXmlProperty(localName = "adoszamEU")
        private String taxNumberEU;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTaxNumber() {
            return taxNumber;
        }

        public void setTaxNumber(String taxNumber) {
            this.taxNumber = taxNumber;
        }

        public String getTaxNumberEU() {
            return taxNumberEU;
        }

        public void setTaxNumberEU(String taxNumberEU) {
            this.taxNumberEU = taxNumberEU;
        }
    }

    public static class RevokeHeader {
        @JacksonXmlProperty(localName = "szamlaszam")
        private String billNumber;
        @JacksonXmlProperty(localName = "keltDatum")
        private LocalDate issuedDate;
        @JacksonXmlProperty(localName = "teljesitesDatum")
        private LocalDate fulfillmentDate;
        @JacksonXmlProperty(localName = "tipus")
        private String type;
        @JacksonXmlProperty(localName = "szamlaSablon")
        private Template template;

        public enum Template {
            SZLA_8CM("Szla8cm"), SZLA_MOST("SzlaMost"), SZLA_ALAP("SzlaAlap"), SZLA_NO_ENV("SzlaNoEnv"),
            SZLA_TOMB("SzlaTomb"), SZLA_FUVARLEVELES_ALAP("SzlaFuvarlevelesAlap");

            private final String value;

            Template(String value) {
                this.value = value;
            }
        }

        public String getBillNumber() {
            return billNumber;
        }

        public void setBillNumber(String billNumber) {
            this.billNumber = billNumber;
        }

        public LocalDate getIssuedDate() {
            return issuedDate;
        }

        public void setIssuedDate(LocalDate issuedDate) {
            this.issuedDate = issuedDate;
        }

        public LocalDate getFulfillmentDate() {
            return fulfillmentDate;
        }

        public void setFulfillmentDate(LocalDate fulfillmentDate) {
            this.fulfillmentDate = fulfillmentDate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Template getTemplate() {
            return template;
        }

        public void setTemplate(Template template) {
            this.template = template;
        }

    }

    public RevokeSettings getSettings() {
        return settings;
    }

    public BillRevokeRequest setSettings(RevokeSettings settings) {
        this.settings = settings;
        return this;
    }

    public RevokeSeller getSeller() {
        return seller;
    }

    public BillRevokeRequest setSeller(RevokeSeller seller) {
        this.seller = seller;
        return this;
    }

    public RevokeBuyer getBuyer() {
        return buyer;
    }

    public BillRevokeRequest setBuyer(RevokeBuyer buyer) {
        this.buyer = buyer;
        return this;
    }

    public RevokeHeader getHeader() {
        return header;
    }

    public BillRevokeRequest setHeader(RevokeHeader header) {
        this.header = header;
        return this;
    }

}
