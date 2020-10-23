package com.saifullin.models;

public class Flight {
    private int id;
    private Date date1;
    private Date date2;
    private Plane plane;
    private City city;
    private String terminal;
    private String type;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight(Date date1, Date date2, Plane plane, City city, String terminal, String type, String status) {
        this.date1 = date1;
        this.date2 = date2;
        this.plane = plane;
        this.city = city;
        this.terminal = terminal;
        this.type = type;
        this.status = status;
    }

    public Flight(int id, Date date1, Date date2, Plane plane, City city, String terminal, String type, String status) {
        this.id = id;
        this.date1 = date1;
        this.date2 = date2;
        this.plane = plane;
        this.city = city;
        this.terminal = terminal;
        this.type = type;
        this.status = status;
    }
}
