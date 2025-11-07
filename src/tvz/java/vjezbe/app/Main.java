package tvz.java.vjezbe.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvz.java.vjezbe.entities.*;
import tvz.java.vjezbe.services.BookingImplementation;
import tvz.java.vjezbe.services.TicketImplementation;


public class Main {

    public static final Integer NUMBER_OF_USERS = 2;
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
    public static final Logger logger = LoggerFactory.getLogger(Main.class);


    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketImplementation ticketService = new TicketImplementation();
        BookingImplementation bookingService = new BookingImplementation();

        System.out.println("Dobrodošli u EventPlanner Hrvatska!\nŽelite li organizirati događanja i korisnike?");

        List<Event> events = new ArrayList<>(3);
        events.add(new CarMeet("Meet na Crnom!",LocalDateTime.parse("19.02.2026. 19:00", format)));
        events.add(new MoviePremiere("Premijera 'Fiume o Morte!' ",LocalDateTime.parse("25.07.2025. 15:00", format)));
        events.add(new Concert("Bow to None Tour", LocalDateTime.parse("29.07.2024. 19:00", format),"Suffocation", "Death metal"));

        for(Event e : events){
            if( e instanceof Concert concert ){
                concert.getEventType();
            }
        }

        if ("DA".equalsIgnoreCase(sc.nextLine())) {

            List<Booking> bookings = bookingService.generateBookings(sc, ticketService);


            System.out.println("Ukupna cijena svih bookinga je: " + bookingService.totalBookingPrice(bookings));

            System.out.print("Želite li najveću ili najmanju cijenu? (MAX/MIN): ");
            String answer = sc.nextLine();

            if ("MAX".equalsIgnoreCase(answer)) {
                System.out.println("Booking s najvećom cijenom: " + bookingService.calculateMaxBooking(bookings));

            } else if ("MIN".equalsIgnoreCase(answer)) {
                System.out.println("Booking s najMANJOM cijenom: " + bookingService.calculateMinBooking(bookings));
            }
            else {
                System.out.println("Krivi upit!");
            }

            System.out.print("Unesite ID: ");
            System.out.println( bookingService.bookingSearch(bookings, sc) );
        }
    }




}






