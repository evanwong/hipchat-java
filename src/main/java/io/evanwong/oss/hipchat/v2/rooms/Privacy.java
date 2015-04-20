package io.evanwong.oss.hipchat.v2.rooms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Privacy {

    PUBLIC("public"), PRIVATE("private");

    private String value;

    @JsonCreator
    Privacy(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
