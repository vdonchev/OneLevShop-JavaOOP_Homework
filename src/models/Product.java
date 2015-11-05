package models;

import enums.AgeRestriction;
import interfaces.Buyable;

public abstract class Product implements Buyable {
    private String name;
    private double price;
    private long quantity;
    private AgeRestriction ageRestriction;

    public Product(String name, double price, long quantity, AgeRestriction ageRestriction) {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        this.ageRestriction = ageRestriction;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("You should provide a valid product name");
        }

        this.name = name;
    }

    public void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException("Price should be positive floating point number");
        }

        this.price = price;
    }

    public void setQuantity(long quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }

        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public double getItemPrice() {
        return price;
    }
}