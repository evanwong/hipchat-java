package io.evanwong.hipchat.v2.commons;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class Request<T> {

    private static final Logger log = LoggerFactory.getLogger(PostRequest.class);

    protected static final String BASE_URL = "https://api.hipchat.com/v2";
    protected ExecutorService executorService;
    protected String accessToken;
    protected HttpClient httpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();
    protected final ObjectWriter objectWriter = objectMapper.writer();
    protected final ObjectReader objectReader = objectMapper.reader(getParameterClass());
    protected abstract Map<String, Object> toQueryMap();
    protected abstract HttpResponse request() throws IOException;
    protected abstract String getPath();

    public Future<T> execute() {

        Future<T> future = executorService.submit(() -> {
            HttpResponse response = request();
            int status = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String content = entity != null ? EntityUtils.toString(entity) : null;
            if (status >= 200 && status < 300) {
                if (content == null) {
                    //should be NoContent
                    return getParameterClass().newInstance();
                }
                return objectReader.readValue(content);
            } else {
                log.error("Invalid response status: {}, content: {}", status, content);
                return null;
            }
        });
        return future;
    }

    protected Class<T> getParameterClass() {
        return (Class<T>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
