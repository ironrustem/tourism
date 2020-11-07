package com.saifullin.models;

public class Fly {
    private User user;
    private Flight flight;

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

    public Fly(User user, Flight flight) {
        this.user = user;
        this.flight = flight;
    }
}
