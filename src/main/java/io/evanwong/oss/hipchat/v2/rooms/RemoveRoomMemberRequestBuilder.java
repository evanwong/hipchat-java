package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class RemoveRoomMemberRequestBuilder extends RequestBuilder<RemoveRoomMemberRequest> {

    private final String roomIdOrName;
    private final String userIdOrEmail;

    public RemoveRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
        this.userIdOrEmail = userIdOrEmail;
    }

    @Override
    public RemoveRoomMemberRequest build() {
        return new RemoveRoomMemberRequest(userIdOrEmail, roomIdOrName, accessToken, httpClient, executorService);
    }

}
