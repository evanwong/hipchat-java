package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetRoomMembersRequestBuilder extends RequestBuilder<GetRoomMembersRequest> {

    private String roomIdOrName;

    public GetRoomMembersRequestBuilder(String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        if (roomIdOrName == null || roomIdOrName.isEmpty()) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        this.roomIdOrName = roomIdOrName;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public GetRoomMembersRequest build() {
        return new GetRoomMembersRequest(roomIdOrName, accessToken, httpClient, executorService);
    }

}
