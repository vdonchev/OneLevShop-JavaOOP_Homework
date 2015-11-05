package models;

import enums.AgeRestriction;
import interfaces.Expirable;
import org.joda.time.DateTime;
import org.joda.time.Days;
import java.time.DateTimeException;

public class FoodProduct extends Product implements Expirable {
    private DateTime expirationDate;

    public FoodProduct(String name, double price, long quantity, AgeRestriction ageRestriction, DateTime expirationDate) {
        super(name, price, quantity, ageRestriction);
        this.setExpirationDate(expirationDate);
    }

    public FoodProduct(String name, double price, long quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction);
    }

    public void setExpirationDate(DateTime expirationDate) {
        if(expirationDate.isBeforeNow()) {
            throw new DateTimeException("Expiration date should be greater than today!");
        }

        this.expirationDate = expirationDate;
    }

    @Override
    public double getPrice() {
        if (Days.daysBetween(DateTime.now(), this.getExpirationDate()).getDays() < 15) {
            return this.getItemPrice() * 0.7;
        }

        return this.getItemPrice();
    }

    @Override
    public DateTime getExpirationDate() {
        return this.expirationDate;
    }
}