package hu.letscode.billing.client;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.common.io.ByteStreams;

import hu.letscode.billing.service.factory.BillingServiceFactory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import hu.letscode.billing.client.factory.HttpPostFactory;
import hu.letscode.billing.client.factory.TrustAllHttpClientFactory;
import hu.letscode.billing.domain.BillRevokeRequest;
import hu.letscode.billing.domain.BillingRevokeResponse;
import hu.letscode.billing.domain.BillRevokeRequest.RevokeHeader;
import hu.letscode.billing.domain.BillRevokeRequest.RevokeHeader.Template;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToXml;
import static org.junit.Assert.*;

public class RevokeBillTest {

    private SzamlaAgentClient underTest;
    private XmlMapper xmlMapper;
    private final String apiUrl = "http://localhost:8089";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Before
    public void setUp() {
        xmlMapper = BillingServiceFactory.createXmlMapper();
        underTest = new SzamlaAgentClient(new TrustAllHttpClientFactory(), new HttpPostFactory(), apiUrl);
    }

    @Test
    public void itShouldSerializeRequestAccordingToScheme() throws IOException {
        // GIVEN
        stubBillingResponse("mock/response/create_bill_failure.xml");
        byte[] content = xmlMapper.writeValueAsBytes(createBillingRequest());
        // WHEN
        underTest.execute(XmlField.STORNO_BILL, content);
        // THEN
        verifyRequest("expected/request/revoke_bill.xml", "action-szamla_agent_st");
    }

    @Test
    public void itShouldSerializeResponseWhenFailure() throws IOException {
        // GIVEN
        stubBillingResponse("mock/response/revoke_bill_failure.xml");
        byte[] content = xmlMapper.writeValueAsBytes(createBillingRequest());
        // WHEN
        InputStream actual = underTest.execute(XmlField.STORNO_BILL, content);
        // THEN
        BillingRevokeResponse response = xmlMapper.readValue(actual, BillingRevokeResponse.class);
        assertFalse(response.isSuccess());
        assertEquals("173", response.getErrorCode());
        assertEquals("A számla kelte nem lehet korábbi, mint az utoljára elkészített számláé (2020.11.29.).", response.getErrorMessage());
    }

    @Test
    public void itShouldSerializeResponseWhenSuccess() throws IOException {
        // GIVEN
        stubBillingResponse("mock/response/revoke_bill_success.xml");
        byte[] content = xmlMapper.writeValueAsBytes(createBillingRequest());
        // WHEN
        InputStream actual = underTest.execute(XmlField.STORNO_BILL, content);
        // THEN
        BillingRevokeResponse response = xmlMapper.readValue(actual, BillingRevokeResponse.class);
        assertTrue(response.isSuccess());
        assertNull(response.getErrorMessage());
        assertNull(response.getErrorCode());
        assertEquals(new BigDecimal(-5000), response.getBillGrossValue());
        assertEquals(new BigDecimal(-5000), response.getBillNetValue());
        assertEquals(new BigDecimal(-5000), response.getReceivable());
        assertEquals("https://www.szamlazz.hu/szamla/?page=vevoifiokpay&partguid=dzsh9qyxgbsnxguryhyxgbsn7ixavmyxgbsn&szfejguid=yvmfg8ebasw6kgqwa5afijnd", response.getUrlForBuyer());
    }

    private void stubBillingResponse(String responseFile) throws IOException {
        byte[] response = ByteStreams.toByteArray(getClass().getClassLoader().getResourceAsStream(responseFile));
        stubFor(post("/").willReturn(aResponse().withStatus(200).withBody(response)));
    }

    private void verifyRequest(String requestFile, String fieldName) throws IOException {
        byte[] response = ByteStreams.toByteArray(getClass().getClassLoader().getResourceAsStream(requestFile));
        wireMockRule.verify(postRequestedFor(urlEqualTo("/")).withAllRequestBodyParts(aMultipart(fieldName)
                .withBody(equalToXml(new String(response)))));
    }

    private BillRevokeRequest createBillingRequest() {
        BillRevokeRequest billingRequest = new BillRevokeRequest();
        billingRequest.setBuyer(createBuyer()).setSeller(createSeller()).setHeader(createHeader())
                .setSettings(createSettings());
        return billingRequest;
    }

    private BillRevokeRequest.RevokeSeller createSeller() {
        BillRevokeRequest.RevokeSeller seller = new BillRevokeRequest.RevokeSeller();
        seller.setEmailReplyTo("fejlesztes@letscode.hu");
        seller.setEmailSubject("Számla értesítő");
        seller.setEmailText("some message");
        return seller;
    }

    private BillRevokeRequest.RevokeSettings createSettings() {
        BillRevokeRequest.RevokeSettings settings = new BillRevokeRequest.RevokeSettings();
        settings.setDownloadBill(false);
                settings.seteBill(false);
                settings.setAgentKey("ujcrrs4aqcxim9bp32rsv5ek6tpkbedwqtns2k7xz6");
        return settings;
    }

    private BillRevokeRequest.RevokeBuyer createBuyer() {
        BillRevokeRequest.RevokeBuyer buyer = new BillRevokeRequest.RevokeBuyer();
        buyer.setEmail("krisztian@letscode.hu");
        return buyer;
    }

    private RevokeHeader createHeader() {
        RevokeHeader header = new RevokeHeader();
        header.setBillNumber("VIDRA-2020-13");
        header.setFulfillmentDate(LocalDate.of(2020, 11, 29 ));
        header.setIssuedDate(LocalDate.of(2020, 11, 29 ));
        header.setTemplate(Template.SZLA_MOST);
        header.setType("SS");
        return header;
    }
}

