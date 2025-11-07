package tvz.java.vjezbe.validator;

import tvz.java.vjezbe.exceptions.InvalidUserInputException;
import java.util.Scanner;

public class InputValidator {
    public String validateName(Scanner sc)
            throws InvalidUserInputException {
        String name = sc.nextLine();

        if(name == null || name.isEmpty()){
            throw new InvalidUserInputException("Ime korisnika ne smije biti prazan!");
        }
        return name;
    }

    public String validateLastName (Scanner sc)
            throws InvalidUserInputException {
        String lastName = sc.nextLine();
        if(lastName == null || lastName.isEmpty()){
            throw new InvalidUserInputException("Prezime korisnika ne smije biti prazno!");
        }
        return lastName;
    }

}
