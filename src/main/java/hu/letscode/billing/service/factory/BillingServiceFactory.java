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
import hu.letscode.billing.domain.serializer.LanguageSerializer;
import hu.letscode.billing.service.BillingService;
import hu.letscode.billing.service.SzamlaAgentBillingService;

/**
 * Factory for creating BillingService instances.
 */
public class BillingServiceFactory {

    /**
     * Creates an XML mapper tailored for the szamlazz.hu request/responses.
     * @return XmlMapper
     */
    public static XmlMapper createXmlMapper() {
        JacksonXmlModule module = new JacksonXmlModule();
        module.addSerializer(Language.class, new LanguageSerializer());
        return XmlMapper.builder().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .findAndAddModules().addModule(module).serializationInclusion(JsonInclude.Include.NON_EMPTY).build();
    }

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     *
     * @return
     */
    public BillingService createSzamlaAgent(Seller seller, Settings settings) {
        return new SzamlaAgentBillingService(createSzamlaAgentClient(), seller,
                settings, createXmlMapper());
    }

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     *
     * @return
     */
    public BillingService createSzamlaAgent(HttpClientFactory httpClientFactory, HttpPostFactory httpPostFactory,
                                            Settings settings, Seller seller) {
        return new SzamlaAgentBillingService(
                new SzamlaAgentClient(httpClientFactory, httpPostFactory, SzamlaAgentClient.SZAMLA_AGENT_API_URL),
                seller, settings, createXmlMapper());
    }

    private SzamlaAgentClient createSzamlaAgentClient() {
        return new SzamlaAgentClient(new DefaultHttpClientFactory(), new HttpPostFactory(),
                SzamlaAgentClient.SZAMLA_AGENT_API_URL);
    }

}
