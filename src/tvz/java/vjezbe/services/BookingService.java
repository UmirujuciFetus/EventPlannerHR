package tvz.java.vjezbe.services;
import tvz.java.vjezbe.entities.Booking;
import tvz.java.vjezbe.entities.Event;

import java.util.List;

import java.util.Optional;
import java.util.Scanner;

public interface BookingService {
    List<Booking> generateBookings(Scanner sc, TicketServiceImpl ticketService, EventServiceImpl eventService);
    Optional<Booking> bookingSearch(List<Booking> bookings, Scanner sc);
    Event chooseUserEvent(EventServiceImpl eventService, Scanner sc);
}
