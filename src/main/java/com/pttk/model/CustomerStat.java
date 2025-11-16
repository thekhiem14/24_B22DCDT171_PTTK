package com.pttk.model;

public class CustomerStat extends Customer{
    private float totalRevenue;
    public CustomerStat() {
        super();
    }
    public float getTotalRevenue() {
        return totalRevenue;
    }
    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
