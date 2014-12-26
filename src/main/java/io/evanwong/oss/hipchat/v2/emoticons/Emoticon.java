package io.evanwong.oss.hipchat.v2.emoticons;

public class Emoticon {

    private Integer id;
    private Integer width;
    private Integer height;
    private String audioPath;
    private String shortcut;

    public Emoticon(Integer id, Integer width, Integer height, String shortcut) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.shortcut = shortcut;
    }

    public Emoticon(Integer id, Integer width, Integer height, String shortcut, String audioPath) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.shortcut = shortcut;
        this.audioPath = audioPath;
    }

    public Integer getId() {
        return id;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public String getShortcut() {
        return shortcut;
    }
}
