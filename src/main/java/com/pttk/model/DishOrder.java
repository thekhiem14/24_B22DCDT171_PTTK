package com.pttk.model;

public class DishOrder extends DetailOrder {
    private Dish dish;

    public DishOrder() {
        super();
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}