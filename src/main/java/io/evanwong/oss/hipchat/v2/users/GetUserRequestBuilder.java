package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetUserRequestBuilder extends RequestBuilder<GetUserRequest> {

    private String roomIdOrName;

    public GetUserRequestBuilder(String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        if (roomIdOrName == null || roomIdOrName.isEmpty()) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        this.roomIdOrName = roomIdOrName;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public GetUserRequest build() {
        return new GetUserRequest(roomIdOrName, accessToken, httpClient, executorService);
    }

}
