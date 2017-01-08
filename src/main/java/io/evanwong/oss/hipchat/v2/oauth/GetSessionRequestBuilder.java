package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.ExpandableRequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetSessionRequestBuilder extends ExpandableRequestBuilder<GetSessionRequestBuilder, GetSessionRequest> {


    public GetSessionRequestBuilder(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    public GetSessionRequest build() {
        if (accessToken == null) {
            throw new IllegalArgumentException("accessToken is required");
        }
        return new GetSessionRequest(accessToken, baseUrl, httpClient, executorService);
    }
}
