package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.NoContent;
import io.evanwong.oss.hipchat.v2.commons.PostRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SendRoomMessageRequest extends PostRequest<NoContent> {

    private String idOrName;
    private String message;

    SendRoomMessageRequest(String idOrName, String message, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrName = idOrName;
        this.message = message;
    }

    public String getIdOrName() {
        return idOrName;
    }

    public String getMessage() {
        return message;
    }

    @Override
    protected String getPath() {
        return "/room/" + idOrName + "/message";
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        return params;
    }
}
