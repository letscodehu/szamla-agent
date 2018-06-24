package billing.client.factory;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 * Created by tacsiazuma on 2017.05.14..
 */
public class DefaultHttpClientFactory implements HttpClientFactory {

    /**
     * {@inheritDoc}
     */
    public CloseableHttpClient create() {
        return HttpClients.createDefault();
    }

}
