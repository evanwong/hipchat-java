package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteUserRequestBuilder extends RequestBuilder<DeleteUserRequest> {
    private final String idOrEmail;

    public DeleteUserRequestBuilder(String idOrEmail, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrEmail = idOrEmail;
    }

    @Override
    public DeleteUserRequest build() {
        if (idOrEmail == null) throw new IllegalArgumentException("idOrEmail is required");
        return new DeleteUserRequest(idOrEmail, accessToken, httpClient, executorService);
    }
}
