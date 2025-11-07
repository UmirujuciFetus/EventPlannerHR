package tvz.java.vjezbe.validator;

import tvz.java.vjezbe.exceptions.InvalidEmailException;
import java.util.Scanner;
/**
 * Služi za validaciju unosa e-maila.
 *
 * @author Karlo Uskok
 * @version 1.0
 * @see InvalidEmailException
 */
public class EmailValidator {

    /**
     * Provjerava točnost unosa e-maila.
     *
     * @throws InvalidEmailException kada je unos {@code null} ili {@code isEmpty()}, te kada
     * e-mail ne odgovara regex formatu {@code ^[A-Za-z0-9+_.-]+@(.+)$}.
     *
     */
    public String validateEmail(Scanner sc) throws InvalidEmailException {
        String email = sc.nextLine();
        if(email == null || email.isEmpty()){
            throw new InvalidEmailException("E-mail ne smije biti prazan!");
        }

        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new InvalidEmailException("Format e-maila nije valjan!");
        }
        return email;
    }
}
