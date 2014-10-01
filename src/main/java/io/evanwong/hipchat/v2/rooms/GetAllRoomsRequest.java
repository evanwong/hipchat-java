package io.evanwong.hipchat.v2.rooms;

import io.evanwong.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetAllRoomsRequest extends GetRequest<Room> {

    private Integer startIndex;
    private Integer maxResults;
    private Boolean includeArchived;

    GetAllRoomsRequest(Integer startIndex, Integer maxResults, Boolean includeArchived, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.includeArchived = includeArchived;
        this.accessToken = accessToken;
        this.httpClient = httpClient;
        this.executorService = executorService;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public Boolean isIncludeArchived() {
        return includeArchived;
    }

    @Override
    protected String getPath() {
        return "/room";
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
        if (includeArchived != null) {
            params.put("include-archived", includeArchived);
        }
        return params;
    }
}
