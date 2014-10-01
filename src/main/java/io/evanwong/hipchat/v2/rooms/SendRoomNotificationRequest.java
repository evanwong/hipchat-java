package io.evanwong.hipchat.v2.rooms;

import io.evanwong.hipchat.v2.commons.NoContent;
import io.evanwong.hipchat.v2.commons.PostRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SendRoomNotificationRequest extends PostRequest<NoContent> {

    private String idOrName;
    private MessageColor color;
    private String message;
    private Boolean notify;
    private String messageFormat;

    public SendRoomNotificationRequest(String idOrName, MessageColor color, String message, Boolean notify, String messageFormat, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        this.accessToken = accessToken;
        this.idOrName = idOrName;
        this.color = color;
        this.message = message;
        this.notify = notify;
        this.messageFormat = messageFormat;
        this.httpClient = httpClient;
        this.executorService = executorService;
    }

    @Override
    protected String getPath() {
        return "/room/" + idOrName + "/notification";
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        if (color != null) {
            params.put("color", color.name().toLowerCase());
        }
        params.put("message", message);
        if (notify != null) {
            params.put("notify", notify);
        }
        if (messageFormat != null) {
            params.put("message_format", messageFormat);
        }
        return params;
    }
}
