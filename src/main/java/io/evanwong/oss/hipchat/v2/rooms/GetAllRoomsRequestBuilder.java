package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.ExpandableRequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetAllRoomsRequestBuilder extends ExpandableRequestBuilder<GetAllRoomsRequestBuilder, GetAllRoomsRequest> {

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

    @Override
    public GetAllRoomsRequest build() {
        if (accessToken == null) {
            throw new IllegalArgumentException("accessToken is required");
        }
        GetAllRoomsRequest getAllRoomsRequest = new GetAllRoomsRequest(startIndex, maxResults, includeArchived, accessToken, httpClient, executorService);
        if (!expansions.isEmpty()) {
            expansions.forEach(title -> getAllRoomsRequest.addExpansion(title));
        }
        return getAllRoomsRequest;
    }
}
