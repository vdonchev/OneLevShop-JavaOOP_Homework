package models;

import enums.AgeRestriction;

public class Computer extends ElectronicProduct {

    public Computer(String name, double price, long quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 24);
    }

    @Override
    public double getPrice() {
        if(this.getQuantity() > 1000) {
            return this.getItemPrice() * 0.95;
        }
        return this.getItemPrice();
    }
}