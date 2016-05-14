package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class DeleteRoomRequestBuilder extends RequestBuilder<DeleteRoomRequest> {

    private final String roomIdOrName;

    public DeleteRoomRequestBuilder(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
    }

    @Override
    public DeleteRoomRequest build() {
        return new DeleteRoomRequest(roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }
}
