package io.evanwong.hipchat.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.evanwong.hipchat.v2.rooms.GetAllRoomsRequestBuilder;
import io.evanwong.hipchat.v2.rooms.SendRoomNotificationRequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HipChatClient {

    private static final Logger log = LoggerFactory.getLogger(HipChatClient.class);

    private CloseableHttpClient httpClient;
    private ExecutorService executorService;
    private String defaultAccessToken;

    public HipChatClient() {
        init();
    }

    public HipChatClient(String defaultAccessToken) {
        this.defaultAccessToken = defaultAccessToken;
        init();
    }

    public void setDefaultAccessToken(String defaultAccessToken) {
        this.defaultAccessToken = defaultAccessToken;
    }

    private void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(20);
        log.debug("Max pool size:100");
        cm.setDefaultMaxPerRoute(4);
        log.debug("Max per route:20");

        httpClient = HttpClients.custom().setConnectionManager(cm).build();
        executorService = Executors.newFixedThreadPool(10);
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder(String accessToken) {
        return new GetAllRoomsRequestBuilder(accessToken, httpClient, executorService);
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder() {
        return prepareGetAllRoomsRequestBuilder(defaultAccessToken);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder(String accessToken) {
        return new SendRoomNotificationRequestBuilder(accessToken, httpClient, executorService);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder() {
        return prepareSendRoomNotificationRequestBuilder(defaultAccessToken);
    }

    public void close() {
        log.info("Shutting down...");
        try {
            httpClient.close();
        } catch (IOException e) {
            log.error("Failed to close the HttpClient.", e);
        }
        executorService.shutdown();
    }

}
