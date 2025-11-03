package tvz.java.vjezbe.exceptions;

/**
 * Bačena kada korisnik unese krive prazne podatke o imenu ili prezimenu.
 * @author Karlo Uskok
 * @since 1.0
 */
public class InvalidUserInputException extends Exception {
    public InvalidUserInputException() {
        super("Invalid user input");
    }

    public InvalidUserInputException(String message) {
        super(message);
    }

    public InvalidUserInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUserInputException(Throwable cause) {
        super(cause);
    }


}
