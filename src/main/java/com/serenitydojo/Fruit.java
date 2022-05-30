package com.serenitydojo;

public class Fruit {

    private String name;
    private String color;
    private String country;

    public Fruit(String name, String color, String country) {
        this.name = name;
        this.color = color;
        this.country = country;
    }

    public Fruit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return name;
    }
}
