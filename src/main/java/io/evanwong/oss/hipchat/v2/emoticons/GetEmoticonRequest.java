package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.GetRequest;
import org.apache.http.client.HttpClient;

import java.util.Map;
import java.util.concurrent.ExecutorService;

public class GetEmoticonRequest extends GetRequest<Emoticon> {

    private final String idOrShortcut;

    GetEmoticonRequest(String idOrShortcut, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.idOrShortcut = idOrShortcut;
    }

    public String getIdOrShortcut() {
        return idOrShortcut;
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        return null;
    }

    @Override
    protected String getPath() {
        return "/v2/emoticon/" + idOrShortcut;
    }
}
