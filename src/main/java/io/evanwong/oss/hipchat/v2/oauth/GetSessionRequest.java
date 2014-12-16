package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetSessionRequest extends GetRequest<Session> {

    private final String sessionId;

    GetSessionRequest(String sessionId, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.sessionId = sessionId;
    }

    @Override
    protected String getPath() {
        return "/oauth/token/" + sessionId;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }
}
