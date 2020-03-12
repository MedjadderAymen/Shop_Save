package com.example.karim.shopandsave.model;

public class Order {
private int id ;
private double price ;
private boolean is_approved ;
private float note ;
private int seller_id ;
private int client_id ;


    public Order(int id, double price, boolean is_approved, float note, int seller_id, int client_id) {
        this.id = id;
        this.price = price;
        this.is_approved = is_approved;
        this.note = note;
        this.seller_id = seller_id;
        this.client_id = client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIs_approved() {
        return is_approved;
    }

    public void setIs_approved(boolean is_approved) {
        this.is_approved = is_approved;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
}
