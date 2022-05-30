package com.serenitydojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Catalog {

    Fruit item;
    private double price;
    private int quantity;
    LocalDateTime created_at;
    LocalDateTime expired_at;

    public Catalog(Fruit item, double price, int quantity, LocalDateTime created_at, LocalDateTime expired_at) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
        this.created_at = created_at;
        this.expired_at = expired_at;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
