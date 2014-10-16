package io.evanwong.oss.hipchat.v2.rooms;

public class RoomLinks {

    private String self;
    private String webhooks;
    private String members;
    private String participants;

    public RoomLinks() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(String webhooks) {
        this.webhooks = webhooks;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }
}
