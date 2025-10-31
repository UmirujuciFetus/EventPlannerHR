package tvz.java.vjezbe.entities;
import java.math.BigDecimal;
import java.util.Scanner;

public sealed interface TicketInterface permits TicketImplementation {
    BigDecimal setTicketPrice(Scanner sc, Integer i);
}
