package tvz.java.vjezbe.services;

import java.math.BigDecimal;
import java.util.Scanner;

public final class TicketImplementation implements TicketInterface {
    @Override
    public BigDecimal setTicketPrice(Scanner sc, Integer i) throws IllegalArgumentException {
        System.out.println("Unesite cijenu " + i + ". ulaznice");

        BigDecimal price = sc.nextBigDecimal();
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Cijena ne smije biti negativna!");
        }

        return price;
    }
}
