package hu.letscode.billing.service.factory;

import javax.xml.bind.JAXBException;

import hu.letscode.billing.client.SzamlaAgentClient;
import hu.letscode.billing.client.factory.DefaultHttpClientFactory;
import hu.letscode.billing.client.factory.HttpClientFactory;
import hu.letscode.billing.client.factory.HttpPostFactory;
import hu.letscode.billing.domain.Seller;
import hu.letscode.billing.domain.Settings;
import hu.letscode.billing.domain.factory.RequestMarshallerFactory;
import hu.letscode.billing.domain.factory.ResponseUnmarshallerFactory;
import hu.letscode.billing.domain.marshaller.RequestMarshaller;
import hu.letscode.billing.domain.marshaller.ResponseUnmarshaller;
import hu.letscode.billing.service.BillingService;
import hu.letscode.billing.service.SzamlaAgentBillingService;

/**
 * Created by tacsiazuma on 2017.05.14..
 */
public class BillingServiceFactory {

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     * @return
     */
    public BillingService createSzamlaAgent(Seller seller, Settings settings) {
        try {
            return new SzamlaAgentBillingService(createSzamlaAgentClient(), createRequestMarshaller(), seller,
                    settings, createResponseUnmarshaller());
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot construct service!", e);
        }
    }

    /**
     * Creates a {@link SzamlaAgentBillingService}.
     * @return
     */
    public BillingService createSzamlaAgent(HttpClientFactory httpClientFactory, HttpPostFactory httpPostFactory,
            Settings settings, Seller seller) {
        try {
            return new SzamlaAgentBillingService(
                    new SzamlaAgentClient(httpClientFactory, httpPostFactory, SzamlaAgentClient.SZAMLA_AGENT_API_URL),
                    createRequestMarshaller(), seller, settings, createResponseUnmarshaller());
        } catch (JAXBException e) {
            throw new RuntimeException("Cannot construct service!", e);
        }
    }

    private SzamlaAgentClient createSzamlaAgentClient() {
        return new SzamlaAgentClient(new DefaultHttpClientFactory(), new HttpPostFactory(),
                SzamlaAgentClient.SZAMLA_AGENT_API_URL);
    }

    private RequestMarshaller createRequestMarshaller() throws JAXBException {
        return RequestMarshallerFactory.newInstance().create();
    }

    private ResponseUnmarshaller createResponseUnmarshaller() throws JAXBException {
        return ResponseUnmarshallerFactory.newInstance().create();
    }
}
