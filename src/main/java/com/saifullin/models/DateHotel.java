package com.saifullin.models;

import java.sql.Date;

public class DateHotel {
    private Date date;
    private Room room;
    private int freeNumberRoom;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getFreeNumberRoom() {
        return freeNumberRoom;
    }

    public void setFreeNumberRoom(int freeNumberRoom) {
        this.freeNumberRoom = freeNumberRoom;
    }

    public DateHotel(Date date, Room room, int freeNumberRoom) {
        this.date = date;
        this.room = room;
        this.freeNumberRoom = freeNumberRoom;
    }

}
