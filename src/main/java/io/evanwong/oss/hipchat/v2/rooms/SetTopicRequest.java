package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.NoContent;
import io.evanwong.oss.hipchat.v2.commons.PutRequest;
import org.apache.http.client.HttpClient;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class SetTopicRequest extends PutRequest<NoContent> {
    
    private String idOrName;
    private String topic;

    public SetTopicRequest(String idOrName, String topic, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrName = idOrName;
        this.topic = topic;
    }

    public String getIdOrName() {
        return idOrName;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    protected String getPath() {
        return "/room/" + this.idOrName + "/topic";
    }
    
    @Override
    protected Map<String, Object> toQueryMap() {
        return Collections.singletonMap("topic", this.topic);
    }

}
