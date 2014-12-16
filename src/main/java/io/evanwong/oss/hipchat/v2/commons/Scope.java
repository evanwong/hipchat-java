package io.evanwong.oss.hipchat.v2.commons;

public enum Scope {

    ADMIN_GROUP,
    ADMIN_ROOM,
    MANAGE_ROOMS,
    SEND_MESSAGE,
    SEND_NOTIFICATION,
    VIEW_GROUP,
    VIEW_MESSAGES;

    public final String getValue() {
        return this.name().toLowerCase();
    }
}
