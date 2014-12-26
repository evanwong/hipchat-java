package io.evanwong.oss.hipchat.v2.rooms;

import io.evanwong.oss.hipchat.v2.commons.Created;
import io.evanwong.oss.hipchat.v2.commons.PostRequest;
import org.apache.http.client.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class CreateRoomRequest extends PostRequest<Created> {

    private String topic;
    private Boolean guestAcccess;
    private String name;
    //The id, email address, or mention name (beginning with an '@') of the room's owner. Defaults to the current user
    private String ownerUserId;
    private Privacy privacy;

    CreateRoomRequest(String topic, Boolean guestAcccess, String name, String ownerUserId, Privacy privacy, String accessToken, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, httpClient, executorService);
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("name is required.");
        }
        this.topic = topic;
        this.guestAcccess = guestAcccess;
        this.name = name;
        this.ownerUserId = ownerUserId;
        this.privacy = privacy;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setGuestAcccess(Boolean guestAcccess) {
        this.guestAcccess = guestAcccess;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    @Override
    protected String getPath() {
        return "/room";
    }

    @Override
    protected Map<String, Object> toQueryMap() {
        Map<String, Object> params = new HashMap<>();
        if (topic != null) {
            params.put("topic", topic);
        }
        if (guestAcccess != null) {
            params.put("guest_acccess", guestAcccess);
        }
        params.put("name", name);
        if (ownerUserId != null) {
            params.put("owner_user_id", ownerUserId);
        }
        if (privacy != null) {
            params.put("privacy", privacy.getValue());
        }
        return params;
    }
}
