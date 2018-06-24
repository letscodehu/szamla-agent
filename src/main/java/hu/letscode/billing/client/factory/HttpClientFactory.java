package hu.letscode.billing.client.factory;

import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Factory for creating {@link CloseableHttpClient}.
 */
public interface HttpClientFactory {

    /**
     * Creates a new {@link CloseableHttpClient}.
     * @return CloseableHttpClient
     */
    CloseableHttpClient create();

}
