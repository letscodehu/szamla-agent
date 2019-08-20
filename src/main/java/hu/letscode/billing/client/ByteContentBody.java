package hu.letscode.billing.client;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.http.entity.mime.content.ContentBody;

/**
 * Content body implementation to imitate a file upload's content.
 */
public class ByteContentBody implements ContentBody {

    private final String name;
    private final byte[] data;

    /**
     * Default constructor.
     * @param name the name of the file
     * @param data the content
     */
    public ByteContentBody(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public String getFilename() {
        return name;
    }

    /**
     * Wries the content of the body to the stream.
     * @param outputStream the stream to write to.
     * @throws IOException if the stream cannot be write into.
     */
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
