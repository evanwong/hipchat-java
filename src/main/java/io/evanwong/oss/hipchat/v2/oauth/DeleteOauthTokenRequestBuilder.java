package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteOauthTokenRequestBuilder extends RequestBuilder<DeleteOauthTokenRequest> {

    private final String sessionId;

    public DeleteOauthTokenRequestBuilder(String sessionId, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.sessionId = sessionId;
    }

    @Override
    public DeleteOauthTokenRequest build() {
        return new DeleteOauthTokenRequest(sessionId, accessToken, httpClient, executorService);
    }
}
