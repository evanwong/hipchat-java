package io.evanwong.oss.hipchat.v2.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public abstract class PutRequest<T> extends Request<T> {

    private static final Logger log = LoggerFactory.getLogger(PutRequest.class);

    protected PutRequest(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws IOException {
        Map<String, Object> params = toQueryMap();
        log.info("PUT - path: {}, params: {}", getPath(), params);

        HttpPut httpPut = new HttpPut(BASE_URL + getPath());
        httpPut.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpPut.addHeader(new BasicHeader("Content-Type", "application/json"));
        httpPut.setEntity(new StringEntity(objectWriter.writeValueAsString(params)));
        return httpClient.execute(httpPut, HttpClientContext.create());
    }
}
