package billing.service.factory;

import billing.client.SzamlaAgentClient;
import billing.client.factory.DefaultHttpClientFactory;
import billing.client.factory.HttpClientFactory;
import billing.client.factory.HttpPostFactory;
import billing.domain.Seller;
import billing.domain.Settings;
import billing.domain.factory.RequestMarshallerFactory;
import billing.domain.marshaller.RequestMarshaller;
import billing.service.BillingService;
import billing.service.SzamlaAgentBillingService;

import javax.xml.bind.JAXBException;

/**
 * Created by tacsiazuma on 2017.05.14..
 */
public class BillingServiceFactory {

    /**
     * Creates a {@link billing.service.SzamlaAgentBillingService}.
     * @return
     */
    public BillingService createSzamlaAgent(Seller seller, Settings settings) {
        try {
            return new SzamlaAgentBillingService(createSzamlaAgentClient(), createRequestMarshaller(), seller, settings);
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot construct service!", e);
        }
    }

    /**
     * Creates a {@link billing.service.SzamlaAgentBillingService}.
     * @return
     */
    public BillingService createSzamlaAgent(HttpClientFactory httpClientFactory,  HttpPostFactory httpPostFactory,
                                            Settings settings, Seller seller) {
        try {
            return new SzamlaAgentBillingService(new SzamlaAgentClient(httpClientFactory, httpPostFactory, SzamlaAgentClient.SZAMLA_AGENT_API_URL),
                    createRequestMarshaller(), seller, settings);
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot construct service!", e);
        }
    }

    private SzamlaAgentClient createSzamlaAgentClient() {
        return new SzamlaAgentClient(new DefaultHttpClientFactory(), new HttpPostFactory(), SzamlaAgentClient.SZAMLA_AGENT_API_URL);
    }

    private RequestMarshaller createRequestMarshaller() throws JAXBException {
        return RequestMarshallerFactory.newInstance().create();
    }

}
