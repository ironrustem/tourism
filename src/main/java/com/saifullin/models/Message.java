package com.saifullin.models;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;

public class Message {

    private int id;
    private int id_user;
    private String text;
    private String file;
    private Timestamp date;
    private String type;
    private String status;

    public Message(int id_user, String text, String file, Timestamp date, String type, String status) {
        this.id_user = id_user;
        this.text = text;
        this.file = file;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    public Message(int id, int id_user, String text, String file, Timestamp date, String type, String status) {
        this.id = id;
        this.id_user = id_user;
        this.text = text;
        this.file = file;
        this.date = date;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
}
