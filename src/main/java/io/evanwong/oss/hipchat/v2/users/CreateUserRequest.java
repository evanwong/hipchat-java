package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.PostRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class CreateUserRequest extends PostRequest<UserItem> {
    private final String username;
    private final String password;
    private final String emailaddress;

    public CreateUserRequest(String username, String password, String emailaddress, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("name", username);
        params.put("password", password);
        params.put("email", emailaddress);

        return params;
    }

    @Override
    protected String getPath() {
        return "/user";
    }
}
