package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetAllEmoticonsRequestBuilder extends RequestBuilder<GetAllEmoticonsRequest> {

    private Integer startIndex;
    private Integer maxResults;
    private EmoticonType type;

    public GetAllEmoticonsRequestBuilder(String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }

    public EmoticonType getType() {
        return type;
    }

    public void setType(EmoticonType type) {
        this.type = type;
    }

    @Override
    public GetAllEmoticonsRequest build() {
        return new GetAllEmoticonsRequest(startIndex, maxResults, type, accessToken, httpClient, executorService);
    }
}
