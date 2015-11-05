import enums.AgeRestriction;
import models.*;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product cigari = new FoodProduct("Victory", 4.99, 20, AgeRestriction.Adult, new DateTime(2016, 11, 1, 20, 00));
        Customer customer = new Customer("Videlin", 19, 10.99);

        PurchaseManager manager = new PurchaseManager();
        try {
            manager.processPurchase(cigari, customer);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println(cigari.getQuantity());
            System.out.println(customer.getBallance());
        }

        List<Product> products = new ArrayList<>();
        products.add(new FoodProduct("Mlqko", 1.88, 33, AgeRestriction.Adult, new DateTime(2015, 11, 17, 13, 55)));
        products.add(new FoodProduct("Hlqb", .99, 89, AgeRestriction.None, new DateTime(2016, 10, 18, 3, 55)));
        products.add(new FoodProduct("Sirene", 10.88, 500, AgeRestriction.None, new DateTime(2015, 12, 18, 13, 55)));
        products.add(new FoodProduct("Vodka", 9.99, 15, AgeRestriction.Adult, new DateTime(2015, 12, 18, 13, 55)));
        products.add(new Computer("HP", 1899.95, 2, AgeRestriction.None));
        products.add(new Computer("Dell", 2.899, 14, AgeRestriction.None));
        products.add(new Computer("Acer", 999, 1, AgeRestriction.Adult));
        products.add(new Appliance("Furna", 499, 156, AgeRestriction.Teenager));
        products.add(new Appliance("Aspirator", 1499.9, 16, AgeRestriction.None));
        products.add(new Appliance("Hladilnik", 4, 0, AgeRestriction.Teenager));


        FoodProduct productExpiringFirst = products.stream()
                .filter(product1 -> product1 instanceof FoodProduct)
                .map(product -> (FoodProduct) product)
                .sorted((o1, o2) -> o1.getExpirationDate().compareTo(o2.getExpirationDate()))
                .findFirst()
                .get();

        System.out.printf("%s: Expiration date: %s", productExpiringFirst.getName(), productExpiringFirst.getExpirationDate());

        System.out.println();
        products.stream()
                .filter(product -> product.getAgeRestriction().equals(AgeRestriction.Adult))
                .sorted((o1, o2) -> Double.compare(o1.getItemPrice(), o2.getItemPrice()))
                .forEach(product1 -> System.out.println(product1.getName() + ": " + product1.getItemPrice()));

    }
}