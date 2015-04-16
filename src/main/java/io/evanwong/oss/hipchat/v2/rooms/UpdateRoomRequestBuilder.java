package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class UpdateRoomRequestBuilder extends RequestBuilder<UpdateRoomRequest> {

    private String roomIdOrName;
    private String name;
    private Privacy	privacy;
    private Boolean	archived;
    private Boolean	guestAccessible;
    private String topic;
    private String ownerIdOrEmail;

    public UpdateRoomRequestBuilder(String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.roomIdOrName = roomIdOrName;
    }

    public UpdateRoomRequestBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UpdateRoomRequestBuilder setPrivacy(Privacy privacy) {
        this.privacy = privacy;
        return this;
    }

    public UpdateRoomRequestBuilder setArchived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    public UpdateRoomRequestBuilder setGuestAccessible(Boolean guestAccessible) {
        this.guestAccessible = guestAccessible;
        return this;
    }

    public UpdateRoomRequestBuilder setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public UpdateRoomRequestBuilder setOwnerIdOrEmail(String ownerIdOrEmail) {
        this.ownerIdOrEmail = ownerIdOrEmail;
        return this;
    }

    @Override
    public UpdateRoomRequest build() {
        if (this.roomIdOrName == null) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        UpdateRoomRequest request = new UpdateRoomRequest(this.roomIdOrName, this.accessToken, this.httpClient, this.executorService);
        request.setArchived(this.archived);
        request.setName(this.name);
        request.setPrivacy(this.privacy);
        request.setGuestAccessible(this.guestAccessible);
        request.setTopic(this.topic);
        request.setOwnerIdOrEmail(this.ownerIdOrEmail);
        return request;
    }
}
