package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetRoomRequest extends GetRequest<Room> {

    private String roomIdOrName;

    GetRoomRequest(String roomIdOrName, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/room/" + roomIdOrName;
    }
}
