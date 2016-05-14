package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteUserRequestBuilder extends RequestBuilder<DeleteUserRequest> {
    private final String idOrEmail;

    public DeleteUserRequestBuilder(String idOrEmail, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.idOrEmail = idOrEmail;
    }

    @Override
    public DeleteUserRequest build() {
        if (idOrEmail == null) throw new IllegalArgumentException("idOrEmail is required");
        return new DeleteUserRequest(idOrEmail, accessToken, baseUrl, httpClient, executorService);
    }
}
