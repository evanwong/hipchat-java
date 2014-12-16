package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetSessionRequestBuilder extends RequestBuilder<GetSessionRequest> {

    private final String sessionId;

    public GetSessionRequestBuilder(String sessionId, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.sessionId = sessionId;
    }

    @Override
    public GetSessionRequest build() {
        return new GetSessionRequest(sessionId, accessToken, httpClient, executorService);
    }
}
