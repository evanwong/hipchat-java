package io.evanwong.oss.hipchat.v2.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class DeleteRequest<T> extends Request<T> {

    private static final Logger log = LoggerFactory.getLogger(DeleteRequest.class);

    protected DeleteRequest(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws IOException {
        Map<String, Object> params = toQueryMap();
        String encodedPath = getEncodedPath();
        log.info("POST - path: {}, params: {}", encodedPath, params);

        HttpDelete httpDelete = new HttpDelete(BASE_URL + encodedPath);
        httpDelete.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpDelete.addHeader(new BasicHeader("Content-Type", "application/json"));
        return httpClient.execute(httpDelete, HttpClientContext.create());
    }
}
