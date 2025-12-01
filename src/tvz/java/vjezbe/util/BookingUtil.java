package tvz.java.vjezbe.util;

import tvz.java.vjezbe.entities.Booking;
import tvz.java.vjezbe.entities.Ticket;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class BookingUtil {
    public static BigDecimal totalPrice(List<Booking> bookings){
        return bookings.stream()
                .map(Booking::tickets)
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    public static Booking maxBooking(List<Booking>bookings){
        return bookings.stream()
                .sorted(Comparator.comparing(b -> b.tickets().getPrice()))
                .toList()
                .reversed()
                .getFirst();
    }
    public static Booking minBooking(List<Booking>bookings){
        bookings.sort(Comparator.comparing(b ->b.tickets().getPrice()));
        return bookings.getFirst();
    }



}
