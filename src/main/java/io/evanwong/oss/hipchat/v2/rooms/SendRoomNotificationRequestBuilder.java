package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class SendRoomNotificationRequestBuilder extends RequestBuilder<SendRoomNotificationRequest> {

    private String idOrName;
    private MessageColor color;
    private String message;
    private Boolean notify;
    private MessageFormat messageFormat;

    public SendRoomNotificationRequestBuilder(String idOrName, String message, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrName = idOrName;
        this.message = message;
    }

    public SendRoomNotificationRequestBuilder setColor(MessageColor color) {
        this.color = color;
        return this;
    }

    public SendRoomNotificationRequestBuilder setNotify(Boolean notify) {
        this.notify = notify;
        return this;
    }

    public SendRoomNotificationRequestBuilder setMessageFormat(MessageFormat messageFormat) {
        this.messageFormat = messageFormat;
        return this;
    }

    public SendRoomNotificationRequest build() {
        if (message == null) {
            throw new IllegalArgumentException("message is required.");
        }
        if (idOrName == null) {
            throw new IllegalArgumentException("idOrName is required.");
        }
        return new SendRoomNotificationRequest(idOrName, color, message, notify, messageFormat, accessToken, httpClient, executorService);
    }
}
