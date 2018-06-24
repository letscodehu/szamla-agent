package billing.client;

import org.apache.http.entity.mime.content.ContentBody;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
public class ByteContentBody implements ContentBody {

    private final String name;
    private final byte[] data;

    public ByteContentBody(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getFilename() {
        return name;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(data);
    }

    public String getMimeType() {
        return "text/xml";
    }

    public String getMediaType() {
        return "text";
    }

    public String getSubType() {
        return "xml";
    }

    public String getCharset() {
        return "utf-8";
    }

    public String getTransferEncoding() {
        return "7bit";
    }

    public long getContentLength() {
        return data.length;
    }
}
