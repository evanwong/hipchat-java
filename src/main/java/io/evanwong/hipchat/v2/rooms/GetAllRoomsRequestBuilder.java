package io.evanwong.hipchat.v2.rooms;

import io.evanwong.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetAllRoomsRequestBuilder extends RequestBuilder {

    private Integer startIndex;
    private Integer maxResults;
    private Boolean includeArchived;

    public GetAllRoomsRequestBuilder(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    public GetAllRoomsRequestBuilder setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public GetAllRoomsRequestBuilder setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    public GetAllRoomsRequestBuilder setIncludeArchived(Boolean includeArchived) {
        this.includeArchived = includeArchived;
        return this;
    }

    public GetAllRoomsRequest build() {
        if (accessToken == null) {
            throw new IllegalArgumentException("accessToken is required");
        }
        return new GetAllRoomsRequest(startIndex, maxResults, includeArchived, accessToken, httpClient, executorService);
    }
}
