package io.evanwong.oss.hipchat.v2;

import io.evanwong.oss.hipchat.v2.emoticons.GetAllEmoticonsRequestBuilder;
import io.evanwong.oss.hipchat.v2.emoticons.GetEmoticonRequestBuilder;
import io.evanwong.oss.hipchat.v2.oauth.GetSessionRequestBuilder;
import io.evanwong.oss.hipchat.v2.rooms.*;
import io.evanwong.oss.hipchat.v2.users.*;
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

    private final CloseableHttpClient httpClient;
    private final ExecutorService executorService;
    private String defaultAccessToken;
    private String baseUrl = "https://api.hipchat.com/v2";
    //TODO move this out
    private static final int MAX_CONNECTIONS = 20;
    //TODO move this out
    private static final int MAX_CONNECTIONS_PER_ROUTE = 4;


    public HipChatClient() {
        this.httpClient = createDefaultHttpClient();
        this.executorService = createDefaultExecutorService();
    }

    public HipChatClient(String defaultAccessToken) {
        this();
        this.defaultAccessToken = defaultAccessToken;
    }

    public HipChatClient(String defaultAccessToken, String baseUrl) {
        this();
        this.defaultAccessToken = defaultAccessToken;
        this.baseUrl = baseUrl;
    }

    public HipChatClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
        this.executorService = createDefaultExecutorService();
    }

    public HipChatClient(ExecutorService executorService) {
        this.httpClient = createDefaultHttpClient();
        this.executorService = executorService;
    }

    public HipChatClient(CloseableHttpClient httpClient, String defaultAccessToken) {
        this(httpClient);
        this.defaultAccessToken = defaultAccessToken;
    }

    public HipChatClient(ExecutorService executorService, String defaultAccessToken) {
        this(executorService);
        this.defaultAccessToken = defaultAccessToken;
    }

    public HipChatClient(CloseableHttpClient httpClient, ExecutorService executorService) {
        this.httpClient = httpClient;
        this.executorService = executorService;
    }

    public HipChatClient(CloseableHttpClient httpClient, ExecutorService executorService, String defaultAccessToken) {
        this(httpClient, executorService);
        this.defaultAccessToken = defaultAccessToken;
    }

    private static CloseableHttpClient createDefaultHttpClient() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(MAX_CONNECTIONS);
        log.debug("Max pool size: {}", MAX_CONNECTIONS);
        cm.setDefaultMaxPerRoute(MAX_CONNECTIONS_PER_ROUTE);
        log.debug("Max per route: {}", MAX_CONNECTIONS_PER_ROUTE);

        return HttpClients.custom().setConnectionManager(cm).build();
    }

    private static ExecutorService createDefaultExecutorService() {
        //setting the thread pool size equal to the max connections size
        return Executors.newFixedThreadPool(MAX_CONNECTIONS);
    }

    public void setDefaultAccessToken(String defaultAccessToken) {
        this.defaultAccessToken = defaultAccessToken;
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder(String accessToken) {
        return new GetAllRoomsRequestBuilder(accessToken, baseUrl, httpClient, executorService);
    }

    public GetAllRoomsRequestBuilder prepareGetAllRoomsRequestBuilder() {
        return prepareGetAllRoomsRequestBuilder(defaultAccessToken);
    }

    public SendRoomMessageRequestBuilder prepareSendRoomMessageRequestBuilder(String idOrName, String message, String accessToken) {
        return new SendRoomMessageRequestBuilder(idOrName, message, accessToken, baseUrl, httpClient, executorService);
    }

    public SendRoomMessageRequestBuilder prepareSendRoomMessageRequestBuilder(String idOrName, String message) {
        return prepareSendRoomMessageRequestBuilder(idOrName, message, defaultAccessToken);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder(String idOrName, String message, String accessToken) {
        return new SendRoomNotificationRequestBuilder(idOrName, message, accessToken, baseUrl, httpClient, executorService);
    }

    public SendRoomNotificationRequestBuilder prepareSendRoomNotificationRequestBuilder(String idOrName, String message) {
        return prepareSendRoomNotificationRequestBuilder(idOrName, message, defaultAccessToken);
    }

    public CreateRoomRequestBuilder prepareCreateRoomRequestBuilder(String name, String accessToken) {
        return new CreateRoomRequestBuilder(name, accessToken, baseUrl, httpClient, executorService);
    }

    public CreateRoomRequestBuilder prepareCreateRoomRequestBuilder(String name) {
        return prepareCreateRoomRequestBuilder(name, defaultAccessToken);
    }

    public GetRoomRequestBuilder prepareGetRoomRequestBuilder(String idOrName, String accessToken) {
        return new GetRoomRequestBuilder(idOrName, accessToken, baseUrl, httpClient, executorService);
    }

    public GetRoomRequestBuilder prepareGetRoomRequestBuilder(String idOrName) {
        return prepareGetRoomRequestBuilder(idOrName, defaultAccessToken);
    }

    public GetEmoticonRequestBuilder prepareGetEmoticonRequestBuilder(String idOrShortcut) {
        return prepareGetEmoticonRequestBuilder(idOrShortcut, defaultAccessToken);
    }

    public GetEmoticonRequestBuilder prepareGetEmoticonRequestBuilder(String idOrShortcut, String accessToken) {
        return new GetEmoticonRequestBuilder(idOrShortcut, accessToken, baseUrl, httpClient, executorService);
    }

    public GetAllEmoticonsRequestBuilder prepareGetAllEmoticonsRequestBuilder() {
        return prepareGetAllEmoticonsRequestBuilder(defaultAccessToken);
    }

    public GetAllEmoticonsRequestBuilder prepareGetAllEmoticonsRequestBuilder(String accessToken) {
        return new GetAllEmoticonsRequestBuilder(accessToken, baseUrl, httpClient, executorService);
    }

    public DeleteRoomRequestBuilder prepareDeleteRoomRequestBuilder(String roomIdOrName) {
        return prepareDeleteRoomRequestBuilder(roomIdOrName, defaultAccessToken);
    }

    public DeleteRoomRequestBuilder prepareDeleteRoomRequestBuilder(String roomIdOrName, String accessToken) {
        return new DeleteRoomRequestBuilder(roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

    public RemoveRoomMemberRequestBuilder prepareRemoveRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName) {
        return prepareRemoveRoomMemberRequestBuilder(userIdOrEmail, roomIdOrName, defaultAccessToken);
    }

    public RemoveRoomMemberRequestBuilder prepareRemoveRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName, String accessToken) {
        return new RemoveRoomMemberRequestBuilder(userIdOrEmail, roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

    public AddRoomMemberRequestBuilder prepareAddRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName) {
        return prepareAddRoomMemberRequestBuilder(userIdOrEmail, roomIdOrName, defaultAccessToken);
    }

    public AddRoomMemberRequestBuilder prepareAddRoomMemberRequestBuilder(String userIdOrEmail, String roomIdOrName, String accessToken) {
        return new AddRoomMemberRequestBuilder(userIdOrEmail, roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

    public SetTopicRequestBuilder prepareSetTopicRequestBuilder(String roomIdOrName, String topic) {
        return prepareSetTopicRequestBuilder(roomIdOrName, topic, defaultAccessToken);
    }

    public SetTopicRequestBuilder prepareSetTopicRequestBuilder(String roomIdOrName, String topic, String accessToken) {
        return new SetTopicRequestBuilder(roomIdOrName, topic, accessToken, baseUrl, httpClient, executorService);
    }

    public UpdateRoomRequestBuilder prepareUpdateRoomRequestBuilder(String roomIdOrName) {
        return prepareUpdateRoomRequestBuilder(roomIdOrName, defaultAccessToken);
    }

    public UpdateRoomRequestBuilder prepareUpdateRoomRequestBuilder(String roomIdOrName, String accessToken) {
        return new UpdateRoomRequestBuilder(roomIdOrName, accessToken, baseUrl, httpClient, executorService);
    }

    public CreateUserRequestBuilder prepareCreateUserRequestBuilder(String username, String password, String emailaddress, String accessToken) {
        return new CreateUserRequestBuilder(username, password, emailaddress, accessToken, baseUrl, httpClient, executorService);
    }

    public CreateUserRequestBuilder prepareCreateUserRequestBuilder(String username, String password, String emailaddress) {
        return prepareCreateUserRequestBuilder(username, password, emailaddress, defaultAccessToken);
    }

    public GetAllUsersRequestBuilder prepareGetAllUsersRequestBuilder(String accessToken) {
        return new GetAllUsersRequestBuilder(accessToken, baseUrl, httpClient, executorService);
    }

    public GetAllUsersRequestBuilder prepareGetAllUsersRequestBuilder() {
        return prepareGetAllUsersRequestBuilder(defaultAccessToken);
    }

    private ViewUserRequestBuilder prepareViewUserRequestBuilder(String idOrEmail, String accessToken) {
        return new ViewUserRequestBuilder(idOrEmail, accessToken, baseUrl, httpClient, executorService);
    }

    public ViewUserRequestBuilder prepareViewUserRequestBuilder(String idOrEmail) {
        return prepareViewUserRequestBuilder(idOrEmail, defaultAccessToken);
    }

    private DeleteUserRequestBuilder prepareDeleteUserRequestBuilder(String idOrEmail, String accessToken) {
        return new DeleteUserRequestBuilder(idOrEmail, accessToken, baseUrl, httpClient, executorService);
    }

    public DeleteUserRequestBuilder prepareDeleteUserRequestBuilder(String idOrEmail) {
        return prepareDeleteUserRequestBuilder(idOrEmail, defaultAccessToken);
    }

    public PrivateMessageUserRequestBuilder preparePrivateMessageUserRequestBuilder(String idOrEmail, String message) {
        return preparePrivateMessageUserRequestBuilder(idOrEmail, message, defaultAccessToken);
    }

    public PrivateMessageUserRequestBuilder preparePrivateMessageUserRequestBuilder(String idOrEmail, String message, String accessToken) {
        return new PrivateMessageUserRequestBuilder(idOrEmail, message, accessToken, baseUrl, httpClient, executorService);
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

    public GetSessionRequestBuilder prepareGetSessionRequestBuilder() {
        return new GetSessionRequestBuilder(defaultAccessToken, baseUrl, httpClient, executorService);
    }

    public GetSessionRequestBuilder prepareGetSessionRequestBuilder(String accessToken) {
        return new GetSessionRequestBuilder(accessToken, baseUrl, httpClient, executorService);
    }
}
