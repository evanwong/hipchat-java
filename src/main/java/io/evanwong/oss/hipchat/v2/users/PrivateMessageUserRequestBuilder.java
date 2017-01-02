package io.evanwong.oss.hipchat.v2.users;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import io.evanwong.oss.hipchat.v2.rooms.MessageFormat;
import io.evanwong.oss.hipchat.v2.users.PrivateMessageUserRequest;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class PrivateMessageUserRequestBuilder extends RequestBuilder<PrivateMessageUserRequest> {

    private String idOrName;
    private String message;
    private Boolean notify;
    private MessageFormat messageFormat;

    public PrivateMessageUserRequestBuilder(String idOrName, String message, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.idOrName = idOrName;
        this.message = message;
    }


    public PrivateMessageUserRequestBuilder setNotify(Boolean notify) {
        this.notify = notify;
        return this;
    }

    public PrivateMessageUserRequestBuilder setMessageFormat(MessageFormat messageFormat) {
        this.messageFormat = messageFormat;
        return this;
    }

    public PrivateMessageUserRequest build() {
        if (message == null) {
            throw new IllegalArgumentException("message is required.");
        }
        if (idOrName == null) {
            throw new IllegalArgumentException("idOrName is required.");
        }
        return new PrivateMessageUserRequest(idOrName, message, notify, messageFormat, accessToken, baseUrl, httpClient, executorService);
    }
}
