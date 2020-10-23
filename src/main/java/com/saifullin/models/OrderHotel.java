package com.saifullin.models;

public class OrderHotel {
    private int id;
    private int price;
    private Room room;
    private int id_user;
    private Date date;
    private int days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public OrderHotel(int price, Room room, int id_user, Date date, int days) {
        this.price = price;
        this.room = room;
        this.id_user = id_user;
        this.date = date;
        this.days = days;
    }

    public OrderHotel(int id, int price, Room room, int id_user, Date date, int days) {
        this.id = id;
        this.price = price;
        this.room = room;
        this.id_user = id_user;
        this.date = date;
        this.days = days;
    }
}
