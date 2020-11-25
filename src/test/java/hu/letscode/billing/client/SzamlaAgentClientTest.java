package hu.letscode.billing.client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.google.common.io.ByteStreams;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import hu.letscode.billing.client.factory.HttpPostFactory;
import hu.letscode.billing.client.factory.TrustAllHttpClientFactory;
import hu.letscode.billing.domain.BillingCreateResponse;
import hu.letscode.billing.domain.BillingRequest;
import hu.letscode.billing.domain.Buyer;
import hu.letscode.billing.domain.Header;
import hu.letscode.billing.domain.Item;
import hu.letscode.billing.domain.Language;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.TaxCode;
import hu.letscode.billing.domain.factory.ItemFactory;
import hu.letscode.billing.domain.factory.RequestMarshallerFactory;
import hu.letscode.billing.domain.factory.ResponseUnmarshallerFactory;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import hu.letscode.billing.domain.marshaller.ResponseUnmarshaller;

/**
 * @author Krisztian_Papp Test class for {@link SzamlaAgentClient}.
 */
public class SzamlaAgentClientTest {

    private SzamlaAgentClient underTest;
    private RequestMarshaller requestMarshaller;
    private ResponseUnmarshaller responseUnmarshaller;
    private String apiUrl = "http://localhost:8089";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Before
    public void setUp() throws Exception {
        underTest = new SzamlaAgentClient(new TrustAllHttpClientFactory(), new HttpPostFactory(), apiUrl);
        requestMarshaller = RequestMarshallerFactory.newInstance().create();
        responseUnmarshaller = ResponseUnmarshallerFactory.newInstance().create();
    }

    @Test
    public void itShouldSerializeResponseWhenFailure() throws JAXBException, IOException {
        // GIVEN
        stubBillingResponse("mock/response/create_bill_failure.xml");
        byte[] content = requestMarshaller.createXmlContent(createBillingRequest());
        // WHEN
        InputStream actual = underTest.execute(XmlField.CREATE_BILL, content);
        // THEN
        BillingCreateResponse response = responseUnmarshaller.marshallResponse(actual, BillingCreateResponse.class);
        assertEquals(false, response.isSuccess());
        assertEquals("3", response.getErrorCode());
        assertEquals("Bejelentkezési hiba - a megadott login név és jelszó pároshoz nem létezik felhasználó",
                response.getErrorMessage());
    }

    @Test
    public void itShouldSerializeResponseWhenSuccess() throws JAXBException, IOException {
        // GIVEN
        stubBillingResponse("mock/response/create_bill_success.xml");
        byte[] content = requestMarshaller.createXmlContent(createBillingRequest());
        // WHEN
        InputStream actual = underTest.execute(XmlField.CREATE_BILL, content);
        // THEN
        BillingCreateResponse response = responseUnmarshaller.marshallResponse(actual, BillingCreateResponse.class);
        assertEquals(true, response.isSuccess());
        assertEquals("XXX-2012-3", response.getBillNumber());
        assertEquals(BigDecimal.valueOf(30000), response.getBillNetValue());
        assertEquals(BigDecimal.valueOf(38100), response.getBillGrossValue());
        assertEquals("content", response.getPdfContent());
    }

    private void stubBillingResponse(String responseFile) throws IOException {
        byte[] response = ByteStreams.toByteArray(getClass().getClassLoader().getResourceAsStream(responseFile));
        stubFor(post("/").willReturn(aResponse().withStatus(200).withBody(response)));
    }

    private BillingRequest createBillingRequest() {
        BillingRequest billingRequest = new BillingRequest();
        billingRequest.setBuyer(createBuyer()).setSeller(createSeller()).setHeader(createHeader())
                .setItems(createItemList()).setSettings(createSettings());
        return billingRequest;
    }

    private Seller createSeller() {
        Seller seller = new Seller();
        seller.setAccountNumber("555555555-55555555-55555555");
        seller.setBankName("OTP");
        seller.setEmailContent("Fizesse ki a számlát");
        seller.setEmailSubject("Számla értesítő");
        seller.setSellerSignatory("Papp Krisztián");
        return seller;
    }

    private Settings createSettings() {
        Settings settings = new Settings();
        settings.setAnswerType(2).setDownloadBill(false).seteBill(false)
                .setAgentKey("ujcrrs4aqcxim9bp32rsv5ek6tpkbedwqtns2k7xz6");
        return settings;
    }

    private List<Item> createItemList() {
        List<Item> items = new ArrayList<Item>();
        items.add(createItem());
        return items;
    }

    private Item createItem() {
        ItemFactory factory = new ItemFactory();
        return factory.create("name", "test", "db", BigDecimal.TEN, BigDecimal.ONE, TaxCode.AAM);
    }

    private Buyer createBuyer() {
        Buyer buyer = new Buyer();
        buyer.setSendMail(true).setComment("test").setAddress("address").setCity("city")
                .setEmail("krisztian@letscode.hu").setName("Papp Krisztián").setPhoneNumber("555-666")
                .setPostalCode("BN1 6UQ").setTaxNumber("12345678-1-42").setSignatoryName("Papp Krisztián");
        return buyer;
    }

    private Header createHeader() {
        Header header = new Header();
        header.setComment("test").setCorrectionBill(false).setFinalBill(false).setLanguage(Language.HU)
                .setDeadlineDate(LocalDateTime.now().plusDays(16)).setLeavenedDate(LocalDateTime.now())
                .setPaymentType("Átutalás").setCurrency(Currency.getInstance("HUF")).setImprestBill(false)
                .setExchangeBank("OTP").setExchangeRate(BigDecimal.ONE).setFulfillmentDate(LocalDateTime.now());
        return header;
    }

}
