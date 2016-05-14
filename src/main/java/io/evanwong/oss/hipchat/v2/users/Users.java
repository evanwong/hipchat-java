package io.evanwong.oss.hipchat.v2.users;

import com.fasterxml.jackson.annotation.JsonSetter;
import io.evanwong.oss.hipchat.v2.commons.PagingLinks;

import java.util.List;

public class Users {
    private List<UserItem> items;
    private PagingLinks links;
    private Integer startIndex;
    private Integer maxResults;

    public Users() {
    }

    public List<UserItem> getItems() {
        return items;
    }

    public void setItems(List<UserItem> items) {
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

    @JsonSetter("startIndex")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    @JsonSetter("maxResults")
    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
