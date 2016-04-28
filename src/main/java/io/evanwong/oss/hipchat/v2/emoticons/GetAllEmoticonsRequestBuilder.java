package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.ExpandableRequestBuilder;
import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetAllEmoticonsRequestBuilder extends ExpandableRequestBuilder<GetAllEmoticonsRequestBuilder, GetAllEmoticonsRequest> {

    private Integer startIndex;
    private Integer maxResults;
    private EmoticonType type;

    public GetAllEmoticonsRequestBuilder(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public GetAllEmoticonsRequestBuilder setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
        return this;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public GetAllEmoticonsRequestBuilder setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    public EmoticonType getType() {
        return type;
    }

    public GetAllEmoticonsRequestBuilder setType(EmoticonType type) {
        this.type = type;
        return this;
    }

    @Override
    public GetAllEmoticonsRequest build() {
        return new GetAllEmoticonsRequest(startIndex, maxResults, type, accessToken, baseUrl, httpClient, executorService);
    }
}
