package exeptions;

public class NotPermissionToBuyException extends Exception {
    public NotPermissionToBuyException(String message) {
        super(message);
    }
}
