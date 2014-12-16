package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteTokenRequestBuilder extends RequestBuilder<DeleteTokenRequest> {

    private final String sessionId;

    public DeleteTokenRequestBuilder(String sessionId, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.sessionId = sessionId;
    }

    @Override
    public DeleteTokenRequest build() {
        return new DeleteTokenRequest(sessionId, accessToken, httpClient, executorService);
    }
}
