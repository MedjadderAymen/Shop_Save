package com.example.karim.shopandsave.model;

public class Comment {

    private int id ;
    private String text ;
    private int commentable_id ;
    private String commentable_type ;
    private int client_id ;


    public Comment(int id, String text, int commentable_id, String commentable_type, int client_id) {
        this.id = id;
        this.text = text;
        this.commentable_id = commentable_id;
        this.commentable_type = commentable_type;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCommentable_id() {
        return commentable_id;
    }

    public void setCommentable_id(int commentable_id) {
        this.commentable_id = commentable_id;
    }

    public String getCommentable_type() {
        return commentable_type;
    }

    public void setCommentable_type(String commentable_type) {
        this.commentable_type = commentable_type;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
