package exeptions;

public class ProductExpiredException extends Exception {
    public ProductExpiredException(String message) {
        super(message);
    }
}
