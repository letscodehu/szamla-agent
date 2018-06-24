package hu.letscode.billing.client;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import hu.letscode.billing.client.factory.HttpPostFactory;
import hu.letscode.billing.client.factory.TrustAllHttpClientFactory;
import hu.letscode.billing.domain.*;
import hu.letscode.billing.domain.factory.ItemFactory;
import hu.letscode.billing.domain.factory.RequestMarshallerFactory;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author Krisztian_Papp
 *  Test class for {@link SzamlaAgentClient}.
 */
public class SzamlaAgentClientTest {


    private SzamlaAgentClient underTest;
    private RequestMarshaller requestMarshaller;
    private String apiUrl = "http://localhost:8089";

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    @Before
    public void setUp() throws Exception {
        underTest = new SzamlaAgentClient(new TrustAllHttpClientFactory(), new HttpPostFactory(), apiUrl);
        requestMarshaller = RequestMarshallerFactory.newInstance().create();
    }

    @Test
    public void itShouldInvokeUrlWithPost() throws JAXBException {
        stubFor(post("/").willReturn(aResponse().withStatus(200).withBody("<response>response</response>")));
        // GIVEN
        byte[] content = requestMarshaller.createXmlContent(createBillingRequest());
        // WHEN
       underTest.execute(XmlField.CREATE_BILL, content);
        // THEN
    }

    private BillingRequest createBillingRequest() {
        BillingRequest billingRequest = new BillingRequest();
        billingRequest.setBuyer(createBuyer()).setSeller(createSeller()).setHeader(createHeader()).setItems(createItemList()).setSettings(createSettings());
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
        settings.setAnswerType(2).setDownloadBill(false).seteBill(false).setUser("letscodehu").setPassword("password").setKeyChainPassword("");
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
                .setEmail("krisztian@letscode.hu").setName("Papp Krisztián")
                .setPhoneNumber("555-666").setPostalCode("BN1 6UQ").setTaxNumber("12345678-1-42").setSignatoryName("Papp Krisztián");
        return buyer;
    }

    private Header createHeader() {
        Header header = new Header();
        header.setComment("test").setCorrectionBill(false).setFinalBill(false).setLanguage(Language.HU).setDeadlineDate(LocalDateTime.now().plusDays(16))
                .setLeavenedDate(LocalDateTime.now()).setPaymentType("Átutalás").setCurrency(Currency.getInstance("HUF"))
                .setImprestBill(false).setExchangeBank("OTP").setExchangeRate(BigDecimal.ONE).setFulfillmentDate(LocalDateTime.now());
        return header;
    }


}