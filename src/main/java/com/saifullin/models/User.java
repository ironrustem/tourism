package com.saifullin.models;

public class User {
    private int id;
    private String name;
    private String surname;
    private String eMail;
    private String telephoneNumber;
    private String priority;
    private String password;

    public User(String name, String surname, String eMail, String telephoneNumber, String priority, String password) {
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.telephoneNumber = telephoneNumber;
        this.priority = priority;
        this.password = password;
    }

    public User(int id, String name, String surname, String eMail, String telephoneNumber, String priority, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.telephoneNumber = telephoneNumber;
        this.priority = priority;
        this.password = password;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
