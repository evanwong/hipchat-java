package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class CreateUserRequestBuilder extends RequestBuilder<CreateUserRequest> {
    private String username;
    private String password;
    private String emailaddress;

    public CreateUserRequestBuilder(String username, String password, String emailaddress, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.username = username;
        this.password = password;
        this.emailaddress = emailaddress;
    }

    public CreateUserRequestBuilder setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
        return this;
    }

    public CreateUserRequestBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public CreateUserRequestBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public CreateUserRequest build() {
        if (username == null) throw new IllegalArgumentException("username is required");
        if (emailaddress == null) throw new IllegalArgumentException("emailaddress is required");

        return new CreateUserRequest(username, password, emailaddress, accessToken, httpClient, executorService);
    }
}
