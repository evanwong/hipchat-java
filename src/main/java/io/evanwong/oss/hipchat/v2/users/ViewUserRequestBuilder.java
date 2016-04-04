package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class ViewUserRequestBuilder extends RequestBuilder<ViewUserRequest> {
    private final String idOrEmail;

    public ViewUserRequestBuilder(String idOrEmail, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrEmail = idOrEmail;
    }

    @Override
    public ViewUserRequest build() {
        if (idOrEmail == null) throw new IllegalArgumentException("idOrEmail is required");
        return new ViewUserRequest(idOrEmail, accessToken, httpClient, executorService);
    }
}
