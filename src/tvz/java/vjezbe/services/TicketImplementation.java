package tvz.java.vjezbe.services;

import java.math.BigDecimal;
import java.util.Scanner;

public final class TicketImplementation implements TicketInterface {
    @Override
    public BigDecimal setTicketPrice(Scanner sc, Integer i) {
        System.out.println("Unesite cijenu " + i + ". ulaznice");

        return sc.nextBigDecimal();
    }
}
