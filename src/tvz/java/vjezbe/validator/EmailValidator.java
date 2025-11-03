package tvz.java.vjezbe.validator;

import tvz.java.vjezbe.exceptions.InvalidEmailException;

public class EmailValidator {
    public void validateEmail(String email) throws InvalidEmailException {
        if(email  == null || email.isEmpty()){
            throw new InvalidEmailException("E-mail ne smije biti prazan!");
        }

        if(!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new InvalidEmailException("Format e-maila nije valjan!");
        }
    }
}
