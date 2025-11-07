package tvz.java.vjezbe.services;
import tvz.java.vjezbe.entities.Booking;
import tvz.java.vjezbe.entities.BookingRecord;
import java.util.List;

import java.math.BigDecimal;
import java.util.Scanner;

public interface BookingInterface {
    BigDecimal totalBookingPrice(List<Booking> bookings);
    Booking calculateMaxBooking(List<Booking> bookings);
    Booking calculateMinBooking(List<Booking> bookings);
    List<Booking> generateBookings(Scanner sc, TicketImplementation ticketService);
    BookingRecord bookingSearch(List<Booking> bookings, Scanner sc);
}
