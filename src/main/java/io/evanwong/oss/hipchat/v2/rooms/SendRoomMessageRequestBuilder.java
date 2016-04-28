package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class SendRoomMessageRequestBuilder extends RequestBuilder<SendRoomMessageRequest> {

    private String idOrName;
    private String message;

    public SendRoomMessageRequestBuilder(String idOrName, String message, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.idOrName = idOrName;
        this.message = message;
    }

    public SendRoomMessageRequest build() {
        if (message == null) {
            throw new IllegalArgumentException("message is required.");
        }
        if (idOrName == null) {
            throw new IllegalArgumentException("idOrName is required.");
        }
        return new SendRoomMessageRequest(idOrName, message, accessToken, baseUrl, httpClient, executorService);
    }
}
