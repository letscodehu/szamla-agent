package hu.letscode.billing.client;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

import hu.letscode.billing.client.factory.HttpClientFactory;
import hu.letscode.billing.client.factory.HttpPostFactory;

/**
 * The client to send requests toward the szamla agent.
 */
public class SzamlaAgentClient {

    public static final String SZAMLA_AGENT_API_URL = "https://www.szamlazz.hu/szamla/?page=main";
    private final HttpClientFactory httpClientFactory;
    private final HttpPostFactory httpPostFactory;
    private final String apiUrl;

    /**
     * Default constructor.
     * @param httpClientFactory the factory to create HTTP clients
     * @param httpPostFactory the factory to create POST requests
     * @param apiUrl the API url.
     */
    public SzamlaAgentClient(HttpClientFactory httpClientFactory, HttpPostFactory httpPostFactory, String apiUrl) {
        this.httpClientFactory = httpClientFactory;
        this.httpPostFactory = httpPostFactory;
        this.apiUrl = apiUrl;
    }

    /**
     * Executes a request toward the API with the given field and content.
     * @param field the field name to be used.
     * @param xmlContent the content of the request body.
     */
    public void execute(XmlField field, byte[] xmlContent) {
        CloseableHttpClient httpClient = httpClientFactory.create();
        HttpPost httpPost = httpPostFactory.createWithEntity(apiUrl, field.getName(), xmlContent);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            response.getStatusLine();
        } catch (IOException e) {
            e.printStackTrace();
            // @TODO handle response errors.
        }

    }

}
