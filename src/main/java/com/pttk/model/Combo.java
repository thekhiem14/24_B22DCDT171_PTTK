package com.pttk.model;

import java.util.List;

public class Combo {
    private int id;
    private String name;
    private String description;
    private float price;
    private List<DishCombo> dishCombos;

    public void setId(int id) {
        this.id = id;
    }

    public List<DishCombo> getDishCombos() {
        return dishCombos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDishCombos(List<DishCombo> dishCombos) {
        this.dishCombos = dishCombos;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
}