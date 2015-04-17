package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.RequestBuilder;
import org.apache.http.client.HttpClient;

import java.util.concurrent.ExecutorService;

public class UpdateRoomRequestBuilder extends RequestBuilder<UpdateRoomRequest> {

    private UpdateRoomRequest updateRoomRequest;

    public UpdateRoomRequestBuilder(String roomIdOrName, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        this.updateRoomRequest = new UpdateRoomRequest(roomIdOrName, accessToken, httpClient, executorService);
    }

    public UpdateRoomRequestBuilder setName(String name) {
        this.updateRoomRequest.setName(name);
        return this;
    }

    public UpdateRoomRequestBuilder setPrivacy(Privacy privacy) {
        this.updateRoomRequest.setPrivacy(privacy);
        return this;
    }

    public UpdateRoomRequestBuilder setArchived(Boolean archived) {
        this.updateRoomRequest.setArchived(archived);
        return this;
    }

    public UpdateRoomRequestBuilder setGuestAccessible(Boolean guestAccessible) {
        this.updateRoomRequest.setGuestAccessible(guestAccessible);
        return this;
    }

    public UpdateRoomRequestBuilder setTopic(String topic) {
        this.updateRoomRequest.setTopic(topic);
        return this;
    }

    public UpdateRoomRequestBuilder setOwnerIdOrEmail(String ownerIdOrEmail) {
        this.updateRoomRequest.setOwnerIdOrEmail(ownerIdOrEmail);
        return this;
    }

    @Override
    public UpdateRoomRequest build() {
        if (updateRoomRequest.getRoomIdOrName() == null) {
            throw new IllegalArgumentException("roomIdOrName is required.");
        }
        if (updateRoomRequest.getName() == null) {
            throw new IllegalArgumentException("name is required.");
        }
        if (updateRoomRequest.getOwnerIdOrEmail() == null) {
            throw new IllegalArgumentException("ownerIdOrEmail is required.");
        }
        if (updateRoomRequest.getPrivacy() == null) {
            throw new IllegalArgumentException("privacy is required.");
        }
        if (updateRoomRequest.getTopic() == null) {
            throw new IllegalArgumentException("topic is required.");
        }
        return updateRoomRequest;
    }
}
