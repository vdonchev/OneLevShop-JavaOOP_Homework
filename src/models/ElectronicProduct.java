package models;

import enums.AgeRestriction;

public abstract class ElectronicProduct extends Product {
    private int guaranteePeriod;

    public ElectronicProduct(String name, double price, long quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.setGuaranteePeriod(guaranteePeriod);
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        if(guaranteePeriod < 0) {
            throw new IllegalArgumentException("Guarantee period should be a positive integer");
        }

        this.guaranteePeriod = guaranteePeriod;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }
}