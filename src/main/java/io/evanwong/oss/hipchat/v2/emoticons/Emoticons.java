package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.PagingLinks;

import java.util.List;

public class Emoticons {
    private final List<EmoticonItem> items;
    private final PagingLinks links;
    private final Integer startIndex;
    private final Integer maxResults;

    public Emoticons(List<EmoticonItem> items, PagingLinks links, Integer startIndex, Integer maxResults) {
        this.items = items;
        this.links = links;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
    }

    public List<EmoticonItem> getItems() {
        return items;
    }

    public PagingLinks getLinks() {
        return links;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }
}
