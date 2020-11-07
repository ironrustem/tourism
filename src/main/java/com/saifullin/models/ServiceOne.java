package com.saifullin.models;

public class ServiceOne {
    private Service service;
    private String checked;

    public ServiceOne(Service service, String checked) {
        this.service = service;
        this.checked = checked;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
