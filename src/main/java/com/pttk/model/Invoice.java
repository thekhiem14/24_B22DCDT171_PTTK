package com.pttk.model;

import java.util.Date;

public class Invoice {
    private int id;
    private Date date;
    private float totalItem;
    private float totalAmount;
    private Customer customer;
    private Order order;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public float getTotalItem() {
        return totalItem;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalItem(float totalItem) {
        this.totalItem = totalItem;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}