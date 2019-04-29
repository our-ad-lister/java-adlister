package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long user_id;
    private String title;
    private String description;
    private String img_url;

    public String getImg_url() {
        return img_url;
    }

    public Ad(long id, long user_id, String title, String description, String img_url ) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.img_url = img_url;
    }

    public Ad(long user_id, String title, String description, String img_url) {
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.img_url = img_url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return user_id;
    }

    public void setUserId(long userId) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
