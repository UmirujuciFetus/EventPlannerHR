package tvz.java.vjezbe.services;
import java.math.BigDecimal;
import java.util.Scanner;

public sealed interface TicketService permits TicketServiceImpl {
    BigDecimal setTicketPrice(Scanner sc, Integer i);
}
