package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetAllUsersRequest extends GetRequest<Users> {
    protected GetAllUsersRequest(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/user";
    }
}
