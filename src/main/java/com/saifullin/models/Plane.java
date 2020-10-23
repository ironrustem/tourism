package com.saifullin.models;

public class Plane {
    private int id;
    private String name;
    private int places;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlaces() {
        return places;
    }

    public Plane(String name, int places) {
        this.name = name;
        this.places = places;
    }

    public Plane(int id, String name, int places) {
        this.id = id;
        this.name = name;
        this.places = places;
    }
}
