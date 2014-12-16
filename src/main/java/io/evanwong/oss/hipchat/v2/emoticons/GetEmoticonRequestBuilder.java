package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class GetEmoticonRequestBuilder extends RequestBuilder<GetEmoticonRequest> {

    private final String idOrShortcut;

    public GetEmoticonRequestBuilder(String idOrShortcut, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrShortcut = idOrShortcut;
    }

    public String getIdOrShortcut() {
        return idOrShortcut;
    }

    @Override
    public GetEmoticonRequest build() {
        return new GetEmoticonRequest(idOrShortcut, accessToken, httpClient, executorService);
    }
}
