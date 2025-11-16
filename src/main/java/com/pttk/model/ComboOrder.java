package com.pttk.model;

public class ComboOrder extends DetailOrder {
    private Combo combo;

    public ComboOrder() {
        super();
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
}