package interfaces;

import org.joda.time.DateTime;

import java.util.Date;

public interface Expirable {
    DateTime getExpirationDate();
}