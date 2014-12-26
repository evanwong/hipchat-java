package io.evanwong.oss.hipchat.v2.emoticons;

import io.evanwong.oss.hipchat.v2.commons.PagingLinks;

import java.util.List;

public class Emoticons {
    private List<EmoticonItem> items;
    private PagingLinks links;
    private Integer startIndex;
    private Integer maxResults;

    public List<EmoticonItem> getItems() {
        return items;
    }

    public void setItems(List<EmoticonItem> items) {
        this.items = items;
    }

    public PagingLinks getLinks() {
        return links;
    }

    public void setLinks(PagingLinks links) {
        this.links = links;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
