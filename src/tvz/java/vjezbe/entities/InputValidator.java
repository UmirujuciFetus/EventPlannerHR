package tvz.java.vjezbe.entities;

public class InputValidator {
    public void validateName(String name)
            throws InvalidUserInputException {
        if(name == null || name.isEmpty()){
            throw new InvalidUserInputException("Ime korisnika ne smije biti prazan!");
        }

    }

    public void validateLastName (String lastName)
            throws InvalidUserInputException {
        if(lastName == null || lastName.isEmpty()){
            throw new InvalidUserInputException("Prezime korisnika ne smije biti prazno!");
        }
    }

}
