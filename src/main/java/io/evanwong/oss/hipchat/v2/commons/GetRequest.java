package io.evanwong.oss.hipchat.v2.commons;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public abstract class GetRequest<T> extends Request<T> {

    private static final Logger log = LoggerFactory.getLogger(GetRequest.class);
    protected List<String> expansions = new ArrayList<>();

    protected GetRequest(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws IOException {
        Map<String, Object> params = toQueryMap();
        if (!expansions.isEmpty()) {
            params.put("expand", expansions.stream().collect(Collectors.joining(",")));
        }
        log.info("GET - path: {}, params: {}", getPath(), params);
        String query = params != null && params.size() > 0 ? "?" : "";
        if (params != null) {
            for (String key : params.keySet()) {
                query += key + "=" + params.get(key) + "&";
            }
        }

        HttpGet httpGet = new HttpGet(BASE_URL + getPath() + query);
        httpGet.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        return httpClient.execute(httpGet, HttpClientContext.create());
    }

    public boolean addExpansion(String title) {
        return expansions.add(title);
    }

    public List<String> getExpansions() {
        return new ArrayList<>(expansions);
    }
}

