package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.DeleteRequest;
import io.evanwong.oss.hipchat.v2.commons.NoContent;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class DeleteOauthTokenRequest extends DeleteRequest<NoContent> {

    private final String sessionId;

    DeleteOauthTokenRequest(String sessionId, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.sessionId = sessionId;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/oauth/token/" + sessionId;
    }
}
