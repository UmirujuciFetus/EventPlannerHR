package tvz.java.vjezbe.exceptions;

public class NegativePriceException extends RuntimeException {
    public NegativePriceException(){super("Cijena ne smije biti negativna!");}

    public NegativePriceException(String message) {
        super(message);
    }

    public NegativePriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativePriceException(Throwable cause) {
        super(cause);
    }
}
