package io.evanwong.oss.hipchat.v2.oauth;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import io.evanwong.oss.hipchat.v2.rooms.Session;
import org.apache.http.client.HttpClient;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetSessionRequest extends GetRequest<Session> {

    GetSessionRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    protected String getPath() {
        return "/oauth/token/" + accessToken;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return Collections.emptyMap();
    }
}
