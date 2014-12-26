package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.evanwong.oss.hipchat.v2.commons.Links;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Room {
    private String xmppJid;
    private Links statistics;
    private String name;
    private RoomLinks links;
    private Date created;
    private Boolean isArchived;
    private Privacy privacy;
    private Boolean isGuestAccessible;
    private String topic;
    private Long id;
    private String guestAccessUrl;

    public String getXmppJid() {
        return xmppJid;
    }

    public void setXmppJid(String xmppJid) {
        this.xmppJid = xmppJid;
    }

    public Links getStatistics() {
        return statistics;
    }

    public void setStatistics(Links statistics) {
        this.statistics = statistics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoomLinks getLinks() {
        return links;
    }

    public void setLinks(RoomLinks links) {
        this.links = links;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Boolean isArchived) {
        this.isArchived = isArchived;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    @JsonSetter("privacy")
    public void setPrivacyStr(String privacyStr) {
        if (privacyStr != null) {
            this.privacy = Privacy.valueOf(privacyStr.toUpperCase());
        }
    }

    public Boolean getIsGuestAccessible() {
        return isGuestAccessible;
    }

    public void setIsGuestAccessible(Boolean isGuestAccessible) {
        this.isGuestAccessible = isGuestAccessible;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestAccessUrl() {
        return guestAccessUrl;
    }

    public void setGuestAccessUrl(String guestAccessUrl) {
        this.guestAccessUrl = guestAccessUrl;
    }
}
