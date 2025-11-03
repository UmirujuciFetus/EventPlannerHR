package tvz.java.vjezbe.exceptions;

/**
 * Bačena kada korisnik unese krivi format e-maila, ili je null.
 * @since 1.0
 * @author Karlo Uskok
 */
public class InvalidEmailException extends Exception {

    /**
     * Stvara {@code InvalidEmailException}bez parametara.
     */
    public InvalidEmailException() {
        super("Invalid email input");
    }

    /**
     * Stvara {@code InvalidEmailException} s porukom.
     * @param message poruka pogreške.
     */
    public InvalidEmailException(String message) {
        super(message);
    }

    /**
     * Stvara {@code InvalidEmailException} s porukom i uzrokom.
     * @param message poruka pogreške.
     * @param cause uzrok iznimke.
     */
    public InvalidEmailException(String message, Throwable cause) {
        super(message,cause);
    }

    /**
     * Stvara {@code InvalidEmailException} s uzrokom.
     * @param cause uzrok iznimke.
     */
    public InvalidEmailException(Throwable cause){
        super(cause);
    }
}
