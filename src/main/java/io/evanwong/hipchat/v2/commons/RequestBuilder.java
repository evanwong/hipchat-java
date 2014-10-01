package io.evanwong.hipchat.v2.commons;

import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public abstract class RequestBuilder {

    protected final String accessToken;
    protected final HttpClient httpClient;
    protected final ExecutorService executorService;

    protected RequestBuilder(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.executorService = executorService;
    }
}
