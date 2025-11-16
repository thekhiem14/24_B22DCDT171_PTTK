package com.pttk.model;

import java.sql.Time;

public class Reservation {
    private int id;
    private Time startTime;
    private Time endTime;
    private float totalAmount;
    private String status;
    private Customer customer;
    private Table table;
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }

    public void setStartTime(Time startTime) {}

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
