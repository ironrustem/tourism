package com.saifullin.models;

public class PriorityFly {
    private int id;
    private String name;
    //на сколько приоритет во времени в регистрациив минутах
    private int timePriority;

    public PriorityFly(String name, int timePriority) {
        this.name = name;
        this.timePriority = timePriority;
    }

    public PriorityFly(int id, String name, int timePriority) {
        this.id = id;
        this.name = name;
        this.timePriority = timePriority;
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

    public int getTimePriority() {
        return timePriority;
    }

    public void setTimePriority(int timePriority) {
        this.timePriority = timePriority;
    }
}
