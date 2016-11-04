package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.NoContent;
import io.evanwong.oss.hipchat.v2.commons.PostRequest;
import io.evanwong.oss.hipchat.v2.rooms.MessageFormat;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class PrivateMessageUserRequest extends PostRequest<NoContent> {

    private String idOrEmail;
    private String message;
    private Boolean notify;
    private MessageFormat messageFormat;

    public PrivateMessageUserRequest(String idOrEmail, String message, Boolean notify, MessageFormat messageFormat, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.idOrEmail = idOrEmail;
        this.message = message;
        this.notify = notify;
        this.messageFormat = messageFormat;
    }

    public String getIdOrEmail() {
        return idOrEmail;
    }


    public String getMessage() {
        return message;
    }

    public Boolean getNotify() {
        return notify;
    }

    public MessageFormat getMessageFormat() {
        return messageFormat;
    }

    @Override
    protected String getPath() {
        return "/user/" + idOrEmail + "/message";
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("message", message);
        if (notify != null) {
            params.put("notify", notify);
        }
        if (messageFormat != null) {
            params.put("message_format", messageFormat.getValue());
        }
        return params;
    }
}
