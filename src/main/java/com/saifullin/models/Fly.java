package com.saifullin.models;

public class Fly {
    private User user;
    private Flight flight;
    private PriorityFly priorityFly;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public PriorityFly getPriorityFly() {
        return priorityFly;
    }

    public void setPriorityFly(PriorityFly priorityFly) {
        this.priorityFly = priorityFly;
    }

    public Fly(User user, Flight flight, PriorityFly priorityFly) {
        this.user = user;
        this.flight = flight;
        this.priorityFly = priorityFly;
    }
}
