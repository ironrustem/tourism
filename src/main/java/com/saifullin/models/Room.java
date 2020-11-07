package com.saifullin.models;

public class Room {
    private int id;
    private String name;
    private String about;
    private String image;
    private int price;
    private int quantity;
    private int persons;
    private String convenience;

    public Room(String name, String about, String image, int price, int quantity, int persons, String convenience) {
        this.name = name;
        this.about = about;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.persons = persons;
        this.convenience = convenience;
    }

    public Room(int id, String name, String about, String image, int price, int quantity, int persons, String convenience) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.persons = persons;
        this.convenience = convenience;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }
}
