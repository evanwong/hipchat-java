package io.evanwong.oss.hipchat.v2.commons;

public class PagingLinks {
    private String self;
    private String prev;
    private String next;

    public PagingLinks() {
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
