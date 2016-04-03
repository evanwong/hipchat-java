package io.evanwong.oss.hipchat.v2.emoticons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EmoticonType {

    GLOBAL("global"), GROUP("group"), ALL("all");

    private String value;

    @JsonCreator
    EmoticonType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
