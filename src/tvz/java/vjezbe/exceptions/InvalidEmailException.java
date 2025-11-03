package tvz.java.vjezbe.exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException() {
        super("Invalid email input");
    }

    public InvalidEmailException(String message) {
        super(message);
    }

    public InvalidEmailException(String message, Throwable cause) {
        super(message,cause);
    }

    public InvalidEmailException(Throwable cause){
        super(cause);
    }
}
