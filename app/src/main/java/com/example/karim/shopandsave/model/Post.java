package com.example.karim.shopandsave.model;

public class Post {
    private int id ;
    private String content ;
    private String image ;
    private boolean enable_comments ;
    private int admin_id ;

    public Post(int id, String content, String image, boolean enable_comments, int admin_id) {
        this.id = id;
        this.content = content;
        this.image = image;
        this.enable_comments = enable_comments;
        this.admin_id = admin_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isEnable_comments() {
        return enable_comments;
    }

    public void setEnable_comments(boolean enable_comments) {
        this.enable_comments = enable_comments;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
