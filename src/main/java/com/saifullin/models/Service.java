package com.saifullin.models;

public class Service {
    private int id;
    private String name;
    private int price;
    private String english;
    private boolean multiply;

    public Service(String name, int price, String english, boolean multiply) {
        this.name = name;
        this.price = price;
        this.english = english;
        this.multiply = multiply;
    }

    public Service(int id, String name, int price, String english, boolean multiply) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.english = english;
        this.multiply = multiply;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public boolean isMultiply() {
        return multiply;
    }

    public void setMultiply(boolean multiply) {
        this.multiply = multiply;
    }
}
