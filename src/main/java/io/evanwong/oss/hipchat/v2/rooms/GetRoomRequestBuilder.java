package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetRoomRequestBuilder extends RequestBuilder<GetRoomRequest> {

    private String roomIdOrName;

    public GetRoomRequestBuilder(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        if (roomIdOrName == null || roomIdOrName.isEmpty()) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        this.roomIdOrName = roomIdOrName;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public GetRoomRequest build() {
        return new GetRoomRequest(roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

}
