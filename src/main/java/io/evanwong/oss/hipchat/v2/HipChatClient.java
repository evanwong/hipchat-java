package io.evanwong.oss.hipchat.v2;

import io.evanwong.oss.hipchat.v2.emoticons.GetAllEmoticonsRequestBuilder;
import io.evanwong.oss.hipchat.v2.emoticons.GetEmoticonRequestBuilder;
import io.evanwong.oss.hipchat.v2.oauth.GenerateTokenRequestBuilder;
import io.evanwong.oss.hipchat.v2.oauth.GrantType;
import io.evanwong.oss.hipchat.v2.rooms.CreateRoomRequestBuilder;
import io.evanwong.oss.hipchat.v2.rooms.GetAllRoomsRequestBuilder;
import io.evanwong.oss.hipchat.v2.rooms.GetRoomRequestBuilder;
import io.evanwong.oss.hipchat.v2.rooms.SendRoomNotificationRequestBuilder;
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
    //TODO move this out
    private int maxConnections = 20;
    //TODO move this out
    private int maxConnectionsPerRoute = 4;


    public HipChatClient() {
        init();
    }

    public HipChatClient(String defaultAccessToken) {
        this.defaultAccessToken = defaultAccessToken;
        init();
    }

    private void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(maxConnections);
        log.debug("Max pool size: {}", maxConnections);
        cm.setDefaultMaxPerRoute(maxConnectionsPerRoute);
        log.debug("Max per route: {}", maxConnectionsPerRoute);

        httpClient = HttpClients.custom().setConnectionManager(cm).build();
        //setting the thread pool size equal to the max connections size
        executorService = Executors.newFixedThreadPool(maxConnections);
    }

    public void setDefaultAccessToken(String defaultAccessToken) {
        this.defaultAccessToken = defaultAccessToken;
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder(String accessToken) {
        return new GetAllRoomsRequestBuilder(accessToken, httpClient, executorService);
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder() {
        return prepareGetAllRoomsRequestBuilder(defaultAccessToken);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder(String idOrName, String message, String accessToken) {
        return new SendRoomNotificationRequestBuilder(idOrName, message, accessToken, httpClient, executorService);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder(String idOrName, String message) {
        return prepareSendRoomNotificationRequestBuilder(idOrName, message, defaultAccessToken);
    }

    public CreateRoomRequestBuilder prepareCreateRoomRequestBuilder(String name, String accessToken) {
        return new CreateRoomRequestBuilder(name, accessToken, httpClient, executorService);
    }

    public CreateRoomRequestBuilder prepareCreateRoomRequestBuilder(String name) {
        return prepareCreateRoomRequestBuilder(name, defaultAccessToken);
    }

    public GetRoomRequestBuilder prepareGetRoomRequestBuilder(String idOrName, String accessToken) {
        return new GetRoomRequestBuilder(idOrName, accessToken, httpClient, executorService);
    }

    public GetRoomRequestBuilder prepareGetRoomRequestBuilder(String idOrName) {
        return prepareGetRoomRequestBuilder(idOrName, defaultAccessToken);
    }

    public GetEmoticonRequestBuilder prepareGetEmoticonRequestBuilder(String idOrShortcut) {
        return prepareGetEmoticonRequestBuilder(idOrShortcut);
    }

    public GetEmoticonRequestBuilder prepareGetEmoticonRequestBuilder(String idOrShortcut, String accessToken) {
        return new GetEmoticonRequestBuilder(idOrShortcut, accessToken, httpClient, executorService);
    }

    public GetAllEmoticonsRequestBuilder prepareGetAllEmoticonsRequestBuilder() {
        return prepareGetAllEmoticonsRequestBuilder(defaultAccessToken);
    }

    public GetAllEmoticonsRequestBuilder prepareGetAllEmoticonsRequestBuilder(String accessToken) {
        return new GetAllEmoticonsRequestBuilder(accessToken, httpClient, executorService);
    }

    public GenerateTokenRequestBuilder prepareGenerateTokenRequestBuilder(GrantType grantType) {
        return prepareGenerateTokenRequestBuilder(grantType, defaultAccessToken);
    }

    public GenerateTokenRequestBuilder prepareGenerateTokenRequestBuilder(GrantType grantType, String accessToken) {
        return new GenerateTokenRequestBuilder(grantType, accessToken, httpClient, executorService);
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
