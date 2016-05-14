package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class SetTopicRequestBuilder extends RequestBuilder<SetTopicRequest> {

    private String roomIdOrName;
    private String topic;

    public SetTopicRequestBuilder(String idOrName, String topic, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = idOrName;
        this.topic = topic;
    }

    @Override
    public SetTopicRequest build() {
        if (topic == null) {
            throw new IllegalArgumentException("topic is required.");
        }
        if (roomIdOrName == null) {
            throw new IllegalArgumentException("idOrName is required.");
        }
        return new SetTopicRequest(roomIdOrName, topic, accessToken, baseUrl, httpClient, executorService);
    }
}
