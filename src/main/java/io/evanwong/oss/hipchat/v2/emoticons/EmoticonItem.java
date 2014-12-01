package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.Links;

public class EmoticonItem {

    private final String url;
    private final Links links;
    private final String id;
    private final String shortcut;

    public EmoticonItem(String url, Links links, String id, String shortcut) {
        this.url = url;
        this.links = links;
        this.id = id;
        this.shortcut = shortcut;
    }

    public String getUrl() {
        return url;
    }

    public Links getLinks() {
        return links;
    }

    public String getId() {
        return id;
    }

    public String getShortcut() {
        return shortcut;
    }
}
