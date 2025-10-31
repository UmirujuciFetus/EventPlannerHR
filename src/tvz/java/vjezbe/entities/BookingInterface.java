package tvz.java.vjezbe.entities;
import java.math.BigDecimal;
import java.util.Scanner;

public interface BookingInterface {
    BigDecimal totalBookingPrice(Booking[] bookings);
    Booking calculateMaxBooking(Booking[] bookings);
    Booking calculateMinBooking(Booking[] bookings);
    BookingRecord bookingSearch(Booking[] bookings, Scanner sc);
}
