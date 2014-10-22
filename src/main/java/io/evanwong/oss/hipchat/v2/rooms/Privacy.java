package io.evanwong.oss.hipchat.v2.rooms;

public enum Privacy {

    PUBLIC("public"), PRIVATE("private");

    private String value;

    Privacy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
