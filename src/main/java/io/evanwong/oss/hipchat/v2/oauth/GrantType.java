package io.evanwong.oss.hipchat.v2.oauth;

public enum GrantType {
    AUTHORIZATION_CODE,
    REFRESH_TOKEN,
    PASSWORD,
    CLIENT_CREDENTIALS,
    PERSONAL,
    ROOM_NOTIFICATION;

    public final String getValue() {
        return name().toLowerCase();
    }
}
