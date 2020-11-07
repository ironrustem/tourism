package com.saifullin.models;

import java.sql.Date;

public class OrderHotel {
    private int id;
    private int price;
    private Room room;
    private int id_user;
    private Date date;
    private Date date1;


    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Room getRoom() {
        return room;
    }

    public int getId_user() {
        return id_user;
    }

    public Date getDate() {
        return date;
    }

    public Date getDate1() {
        return date1;
    }

    public OrderHotel(int price, Room room, int id_user, Date date, Date date1) {
        this.price = price;
        this.room = room;
        this.id_user = id_user;
        this.date = date;
        this.date1 = date1;
    }

    public OrderHotel(int id, int price, Room room, int id_user, Date date, Date date1) {
        this.id = id;
        this.price = price;
        this.room = room;
        this.id_user = id_user;
        this.date = date;
        this.date1 = date1;
    }
}
