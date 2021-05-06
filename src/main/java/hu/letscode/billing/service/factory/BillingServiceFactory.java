package hu.letscode.billing.service.factory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.factory.DefaultHttpClientFactory;
import hu.letscode.billing.client.factory.HttpClientFactory;
import hu.letscode.billing.client.factory.HttpPostFactory;
import hu.letscode.billing.domain.Language;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.TaxCode;
import hu.letscode.billing.domain.serializer.LanguageSerializer;
import hu.letscode.billing.domain.serializer.TaxCodeSerializer;
import hu.letscode.billing.service.BillingService;
import hu.letscode.billing.service.SzamlaAgentBillingService;

/**
 * Factory for creating BillingService instances.
 */
public class BillingServiceFactory {

    /**
     * Creates an XML mapper tailored for the szamlazz.hu request/responses.
     * 
     * @return {@link XmlMapper}
     */
    public static XmlMapper createXmlMapper() {
        JacksonXmlModule module = new JacksonXmlModule();
        module.addSerializer(Language.class, new LanguageSerializer());
        module.addSerializer(TaxCode.class, new TaxCodeSerializer());
        return XmlMapper.builder().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).findAndAddModules()
                .addModule(module).serializationInclusion(JsonInclude.Include.NON_EMPTY).build();
    }

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     *
     * @param seller   the seller object
     * @param settings the default settings object
     * @return {@link BillingService}
     */
    public BillingService createSzamlaAgent(Seller seller, Settings settings) {
        return new SzamlaAgentBillingService(createSzamlaAgentClient(), createXmlMapper());
    }

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     *
     * @param httpClientFactory client factory
     * @param httpPostFactory   post object factory
     * @param settings          the default settings
     * @param seller            the default seller
     *
     * @return {@link BillingService}
     */
    public BillingService createSzamlaAgent(HttpClientFactory httpClientFactory, HttpPostFactory httpPostFactory,
            Settings settings, Seller seller) {
        return new SzamlaAgentBillingService(
                new SzamlaAgentClient(httpClientFactory, httpPostFactory, SzamlaAgentClient.SZAMLA_AGENT_API_URL),
                createXmlMapper());
    }

    private SzamlaAgentClient createSzamlaAgentClient() {
        return new SzamlaAgentClient(new DefaultHttpClientFactory(), new HttpPostFactory(),
                SzamlaAgentClient.SZAMLA_AGENT_API_URL);
    }

}
