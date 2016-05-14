package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class AddRoomMemberRequestBuilder extends RequestBuilder<AddRoomMemberRequest> {

    private final String roomIdOrName;
    private final String userIdOrEmail;

    public AddRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
        this.userIdOrEmail = userIdOrEmail;
    }

    @Override
    public AddRoomMemberRequest build() {
        return new AddRoomMemberRequest(userIdOrEmail, roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

}
