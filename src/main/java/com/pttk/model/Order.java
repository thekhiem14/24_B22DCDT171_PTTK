package com.pttk.model;

import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date date;
    private int totalItem;
    private float totalAmount;
    private List<DetailOrder> detailOrder;
    private Customer customer;
    private Reservation reservation;

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

    public List<DetailOrder> getDetailOrder() {
        return detailOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setDetailOrder(List<DetailOrder> detailOrder) {
        this.detailOrder = detailOrder;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}