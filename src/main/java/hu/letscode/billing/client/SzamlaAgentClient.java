package hu.letscode.billing.client;

import hu.letscode.billing.client.factory.HttpClientFactory;
import hu.letscode.billing.client.factory.HttpPostFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * The client to send requests toward the szamla agent.
 */
public class SzamlaAgentClient {

    private final HttpClientFactory httpClientFactory;
    private final HttpPostFactory httpPostFactory;
    private final String apiUrl;

    public static final String SZAMLA_AGENT_API_URL = "https://www.szamlazz.hu/szamla/?page=main";

    public SzamlaAgentClient(HttpClientFactory httpClientFactory, HttpPostFactory httpPostFactory, String apiUrl) {
        this.httpClientFactory = httpClientFactory;
        this.httpPostFactory = httpPostFactory;
        this.apiUrl = apiUrl;
    }

    public void execute(XmlField field, byte[] xmlContent) {
        CloseableHttpClient httpClient = httpClientFactory.create();
        HttpPost httpPost = httpPostFactory.createWithEntity(apiUrl, field.getName(), xmlContent);
        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);
            response.getStatusLine();
            InputStream inputStream = response.getEntity().getContent();
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
            // @TODO handle response errors.
        }

    }

}
