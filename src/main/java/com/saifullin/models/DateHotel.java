package com.saifullin.models;

public class DateHotel {
    private int id;
    private Date date;
    private Room room;
    private int allNumberRoom;
    private int freeNumberRoom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAllNumberRoom() {
        return allNumberRoom;
    }

    public void setAllNumberRoom(int allNumberRoom) {
        this.allNumberRoom = allNumberRoom;
    }

    public int getFreeNumberRoom() {
        return freeNumberRoom;
    }

    public void setFreeNumberRoom(int freeNumberRoom) {
        this.freeNumberRoom = freeNumberRoom;
    }

    public DateHotel(Date date, Room room, int allNumberRoom, int freeNumberRoom) {
        this.date = date;
        this.room = room;
        this.allNumberRoom = allNumberRoom;
        this.freeNumberRoom = freeNumberRoom;
    }

    public DateHotel(int id, Date date, Room room, int allNumberRoom, int freeNumberRoom) {
        this.id = id;
        this.date = date;
        this.room = room;
        this.allNumberRoom = allNumberRoom;
        this.freeNumberRoom = freeNumberRoom;
    }
}
