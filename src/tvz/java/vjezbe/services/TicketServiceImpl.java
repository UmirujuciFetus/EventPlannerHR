package tvz.java.vjezbe.services;

import tvz.java.vjezbe.exceptions.NegativePriceException;
import java.math.BigDecimal;
import java.util.Scanner;

public final class TicketServiceImpl implements TicketService {
    @Override
    public BigDecimal setTicketPrice(Scanner sc, Integer i) throws NegativePriceException{
        System.out.println("Unesite cijenu " + i + ". ulaznice");

        BigDecimal price = sc.nextBigDecimal();
        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new NegativePriceException();
        }
        return price;
    }
}
