import enums.AgeRestriction;
import exeptions.*;
import models.Customer;
import models.FoodProduct;
import models.Product;

public final class PurchaseManager {
    public void processPurchase(Product product, Customer customer) throws Exception {
        if (product.getQuantity() <= 0) {
            throw new OutOfStockException("Item is out of stock");
        }

        if(product instanceof FoodProduct) {
            FoodProduct prd = (FoodProduct) product;
            if(prd.getExpirationDate().isBeforeNow()) {
                throw new ProductExpiredException("Item expiration date is over");
            }
        }

        if (customer.getBallance() < product.getItemPrice()) {
            throw new NotEnoughMoneyException("You do not have enough money to buy this product!");
        }

        if (customer.getAge() < 18 && product.getAgeRestriction().equals(AgeRestriction.Adult)
                || customer.getAge() < 16 && product.getAgeRestriction().equals(AgeRestriction.Teenager)) {
            throw new NotPermissionToBuyException("You are too young to buy this product!");
        }

        customer.setBallance(customer.getBallance() - product.getItemPrice());
        product.setQuantity(product.getQuantity() - 1);
    }
}
