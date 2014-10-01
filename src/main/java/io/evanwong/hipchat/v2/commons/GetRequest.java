package io.evanwong.hipchat.v2.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public abstract class GetRequest<T> extends Request {

    private static final Logger log = LoggerFactory.getLogger(GetRequest.class);

    @Override
    protected HttpResponse request() throws IOException {
        Map<String, Object> params = toQueryMap();
        log.info("GET - path: {}, params: {}", getPath(), params);
        String query = params != null && params.size() > 0 ? "?" : "";
        for (String key : params.keySet()) {
            query += key + "=" + params.get(key) + "&";
        }

        HttpGet httpGet = new HttpGet(BASE_URL + getPath() + query);
        httpGet.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        return httpClient.execute(httpGet, HttpClientContext.create());
    }


}

