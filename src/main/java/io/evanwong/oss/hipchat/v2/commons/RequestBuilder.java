package io.evanwong.oss.hipchat.v2.commons;

import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public abstract class RequestBuilder<T> {

    protected final String accessToken;
    protected final String baseUrl;
    protected final HttpClient httpClient;
    protected final ExecutorService executorService;

    protected RequestBuilder(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        this.accessToken = accessToken;
        this.baseUrl = baseUrl;
        this.httpClient = httpClient;
        this.executorService = executorService;
    }

    public abstract T build();
}
