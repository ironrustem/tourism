package com.saifullin.models;

import java.sql.Timestamp;

public class Flight {
    private int id;
    private Timestamp date1;
    private Timestamp date2;
    private Plane plane;
    private City city;
    private String terminal;
    private String type;
    private String status;
    private String number;
    private String company;

    public Flight(Timestamp date1, Timestamp date2, Plane plane, City city, String terminal, String type, String status, String number, String company) {
        this.date1 = date1;
        this.date2 = date2;
        this.plane = plane;
        this.city = city;
        this.terminal = terminal;
        this.type = type;
        this.status = status;
        this.number = number;
        this.company = company;
    }

    public Flight(int id, Timestamp date1, Timestamp date2, Plane plane, City city, String terminal, String type, String status, String number, String company) {
        this.id = id;
        this.date1 = date1;
        this.date2 = date2;
        this.plane = plane;
        this.city = city;
        this.terminal = terminal;
        this.type = type;
        this.status = status;
        this.number = number;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate1() {
        return date1;
    }

    public void setDate1(Timestamp date1) {
        this.date1 = date1;
    }

    public Timestamp getDate2() {
        return date2;
    }

    public void setDate2(Timestamp date2) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
