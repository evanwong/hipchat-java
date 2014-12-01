package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class CreateRoomRequestBuilder extends RequestBuilder<CreateRoomRequest> {
    private String topic;
    private Boolean guestAcccess;
    private String name;
    //The id, email address, or mention name (beginning with an '@') of the room's owner. Defaults to the current user
    private String ownerUserId;
    private Privacy privacy;

    public CreateRoomRequestBuilder(String name, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.name = name;
    }

    public CreateRoomRequestBuilder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public CreateRoomRequestBuilder setGuestAcccess(Boolean guestAcccess) {
        this.guestAcccess = guestAcccess;
        return this;
    }

    public CreateRoomRequestBuilder setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
        return this;
    }

    public CreateRoomRequestBuilder setPrivacy(Privacy privacy) {
        this.privacy = privacy;
        return this;
    }

    @Override
    public CreateRoomRequest build() {
        if (name == null) {
            throw new IllegalArgumentException("name is required.");
        }
        return new CreateRoomRequest(topic, guestAcccess, name, ownerUserId, privacy, accessToken, httpClient, executorService);
    }
}
