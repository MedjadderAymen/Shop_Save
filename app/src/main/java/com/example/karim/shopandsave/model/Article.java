package com.example.karim.shopandsave.model;

public class Article {


    private int id ;
    private String title ;
    private String image ;
    private double old_price ;
    private double new_price ;
    private int users_id ;

    public Article(int id, String title, String image, double old_price, double new_price, int users_id) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.old_price = old_price;
        this.new_price = new_price;
        this.users_id = users_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getOld_price() {
        return old_price;
    }

    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }

    public double getNew_price() {
        return new_price;
    }

    public void setNew_price(double new_price) {
        this.new_price = new_price;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
}
