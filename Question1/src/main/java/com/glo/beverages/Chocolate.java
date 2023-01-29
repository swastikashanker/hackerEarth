package com.glo.beverages;

public class Chocolate extends BeverageDecorator{

    private int cost;
    private Beverage beverage;

    public Chocolate(int cost, Beverage beverage) {
        this.cost = cost;
        this.beverage = beverage;
    }

    @Override
    public int getCost() {
        return this.cost + this.beverage.getCost();
    }

    @Override
    public String getDescription() {
        return this.beverage.getDescription() + " topped with chocolate";
    }
}
