package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class SetTopicRequestBuilder extends RequestBuilder<SetTopicRequest> {

    private String idOrName;
    private String topic;

    public SetTopicRequestBuilder(String idOrName, String topic, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrName = idOrName;
        this.topic = topic;
    }

    @Override
    public SetTopicRequest build() {
        if (topic == null) {
            throw new IllegalArgumentException("topic is required.");
        }
        if (idOrName == null) {
            throw new IllegalArgumentException("idOrName is required.");
        }
        return new SetTopicRequest(idOrName, topic, accessToken, httpClient, executorService);
    }
}
