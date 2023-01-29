package com.glo.beverages;

public class Caramel extends BeverageDecorator {

    private int cost;
    private Beverage beverage;

    public Caramel(int cost, Beverage beverage) {
        this.cost = cost;
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return this.cost + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " topped with caramel";
    }
}
