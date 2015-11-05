package models;

import enums.AgeRestriction;

public class Appliance extends ElectronicProduct {
    public Appliance(String name, double price, long quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    @Override
    public double getPrice() {
        if(this.getQuantity() < 50) {
            return this.getItemPrice() * 1.05;
        }

        return this.getItemPrice();
    }
}