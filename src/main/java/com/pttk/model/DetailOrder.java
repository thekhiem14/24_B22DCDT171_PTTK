package com.pttk.model;

public class DetailOrder {
    private int id;
    private int quantity;
    private float unitPrice;
    private float amount;
    private DishOrder dishOrder;
    private ComboOrder comboOrder;

    public int getQuantity() {
        return quantity;
    }

    public int getId() {
        return id;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public float getAmount() {
        return amount;
    }

    public DishOrder getDishOrder() {
        return dishOrder;
    }

    public ComboOrder getComboOrder() {
        return comboOrder;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDishOrder(DishOrder dishOrder) {
        this.dishOrder = dishOrder;
    }

    public void setComboOrder(ComboOrder comboOrder) {
        this.comboOrder = comboOrder;
    }
}