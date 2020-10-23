package com.saifullin.models;

public class ServicesOrder {
    private Service service;
    private OrderHotel order;

    public void setService(Service service) {
        this.service = service;
    }

    public void setOrder(OrderHotel order) {
        this.order = order;
    }

    public Service getService() {
        return service;
    }

    public OrderHotel getOrder() {
        return order;
    }

    public ServicesOrder(Service service, OrderHotel order) {
        this.service = service;
        this.order = order;
    }
}
