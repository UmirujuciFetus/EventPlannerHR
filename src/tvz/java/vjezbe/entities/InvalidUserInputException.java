package tvz.java.vjezbe.entities;

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
