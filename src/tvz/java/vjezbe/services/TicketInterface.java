package tvz.java.vjezbe.services;
import java.math.BigDecimal;
import java.util.Scanner;

public sealed interface TicketInterface permits TicketImplementation {
    BigDecimal setTicketPrice(Scanner sc, Integer i);
}
