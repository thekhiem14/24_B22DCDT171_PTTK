package com.pttk.model;

public class DishCombo {
    private int id;
    private Dish dish;
    private String note;
    private int quantity;
    private int displayNumber;

    public Dish getDish() {
        return dish;
    }

    public int getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(int displayNumber) {
        this.displayNumber = displayNumber;
    }

    public int getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
