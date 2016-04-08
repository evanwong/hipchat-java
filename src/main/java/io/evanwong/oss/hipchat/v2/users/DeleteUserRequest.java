package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.DeleteRequest;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class DeleteUserRequest extends DeleteRequest<UserItem> {
    private final String idOrEmail;

    public DeleteUserRequest(String idOrEmail, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrEmail = idOrEmail;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/user/" + idOrEmail;
    }
}