package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.NoContent;
import io.evanwong.oss.hipchat.v2.commons.PutRequest;
import org.apache.http.client.HttpClient;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SetTopicRequest extends PutRequest<NoContent> {
    
    private String roomIdOrName;
    private String topic;

    public SetTopicRequest(String idOrName, String topic, String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
        this.roomIdOrName = idOrName;
        this.topic = topic;
    }

    public String getRoomIdOrName() {
        return roomIdOrName;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    protected String getPath() {
        return "/room/" + this.roomIdOrName + "/topic";
    }
    
    @Override
    protected Map<String, Object> toQueryMap() {
        return Collections.singletonMap("topic", this.topic);
    }

}
