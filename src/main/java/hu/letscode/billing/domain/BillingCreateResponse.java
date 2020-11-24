package hu.letscode.billing.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The API response.
 */
@XmlRootElement(namespace = "http://www.szamlazz.hu/xmlszamlavalasz", name = "xmlszamlavalasz")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingCreateResponse {

    @XmlElement(name = "sikeres")
    private boolean success;
    @XmlElement(name = "szamlaszam")
    private String billNumber;
    @XmlElement(name = "szamlanetto")
    private BigDecimal billNetValue;
    @XmlElement(name = "szamlabrutto")
    private BigDecimal billGrossValue;
    @XmlElement(name = "pdf")
    private String pdfContent;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public BigDecimal getBillNetValue() {
        return billNetValue;
    }

    public void setBillNetValue(BigDecimal billNetValue) {
        this.billNetValue = billNetValue;
    }

    public BigDecimal getBillGrossValue() {
        return billGrossValue;
    }

    public void setBillGrossValue(BigDecimal billGrossValue) {
        this.billGrossValue = billGrossValue;
    }

    public String getPdfContent() {
        return pdfContent;
    }

    public void setPdfContent(String pdfContent) {
        this.pdfContent = pdfContent;
    }

}
