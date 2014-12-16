package io.evanwong.oss.hipchat.v2.commons;

import org.apache.http.client.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class ExpandableRequestBuilder<T, E> extends RequestBuilder<E> {

    protected final List<String> expansions;

    public ExpandableRequestBuilder(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        expansions = new ArrayList<>();
    }

    public T addExpansion(String title) {
        expansions.add(title);
        return (T)this;
    }
}
