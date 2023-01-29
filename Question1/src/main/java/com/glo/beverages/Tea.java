package com.glo.beverages;

public class Tea implements Beverage {
    private int cost;

    public Tea(int cost){
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return "Tea";
    }
}
