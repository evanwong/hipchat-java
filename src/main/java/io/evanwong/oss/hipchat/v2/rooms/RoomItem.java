package io.evanwong.oss.hipchat.v2.rooms;

public class RoomItem {
    private Long id;
    private RoomLinks links;
    private String name;

    public RoomItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomLinks getLinks() {
        return links;
    }

    public void setLinks(RoomLinks links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
