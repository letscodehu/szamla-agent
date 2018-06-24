package billing.client.factory;

import billing.client.ByteContentBody;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;

/**
 * Class for creating {@link HttpPost} with multipart entites in it.
 */
public class HttpPostFactory {

    /**
     * Creates a {@link HttpPost}.
     * @param url the URL to point the request
     * @param fieldName the field to put the file in
     * @param multipartContent the content of the file
     * @return HttpPost filled with the multipart entity
     */
    public HttpPost createWithEntity(String url, String fieldName, byte[] multipartContent) {
        HttpPost httpPost = new HttpPost(url);
        ByteContentBody body = new ByteContentBody(fieldName, multipartContent);
        HttpEntity requestEntity = MultipartEntityBuilder.create().addPart(fieldName, body).build();
        httpPost.setEntity(requestEntity);
        return httpPost;
    }

}
