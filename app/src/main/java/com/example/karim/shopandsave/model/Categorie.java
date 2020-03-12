package com.example.karim.shopandsave.model;

public class Categorie {

    private int id ;
    private String name ;
    private boolean featured ;

    public Categorie(int id, String name, boolean featured) {
        this.id = id;
        this.name = name;
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }
}
