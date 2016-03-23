package io.evanwong.oss.hipchat.v2.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserItem {
    private String mentionName;
    private String version;
    private int id;
    private String name;

    public UserItem() {
    }

    public String getMentionName() {
        return mentionName;
    }

    public void setMentionName(String mentionName) {
        this.mentionName = mentionName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
