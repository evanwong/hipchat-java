package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetAllEmoticonsRequest extends GetRequest<Emoticons> {

    private final Integer startIndex;
    private final Integer maxResults;
    private final EmoticonType type;

    GetAllEmoticonsRequest(Integer startIndex, Integer maxResults, EmoticonType type, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.type = type;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public EmoticonType getType() {
        return type;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        if (startIndex != null) {
            params.put("start-index", startIndex);
        }
        if (maxResults != null) {
            params.put("max-results", maxResults);
        }
        if (type != null) {
            params.put("type", type.name().toLowerCase());
        }
        return params;
    }

    @Override
    protected String getPath() {
        return "/emoticon";
    }
}
