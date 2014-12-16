package io.evanwong.oss.hipchat.v2.oauth;

public enum TokenType {

    BEARER;

    public final String getValue() {
        return this.name().toLowerCase();
    }

}
