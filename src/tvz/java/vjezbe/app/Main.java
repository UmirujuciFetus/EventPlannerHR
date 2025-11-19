package tvz.java.vjezbe.app;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvz.java.vjezbe.entities.*;

import tvz.java.vjezbe.services.BookingServiceImpl;
import tvz.java.vjezbe.services.EventServiceImpl;
import tvz.java.vjezbe.services.TicketServiceImpl;

import tvz.java.vjezbe.util.BookingUtil;


public class Main {

    //stavit u enum ako je moguce
    public static final Integer NUMBER_OF_USERS = 2;
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
    public static final Logger logger = LoggerFactory.getLogger(Main.class);


    static void main(String[] args) {
        logger.info("ZAPOČET NOVI PROGRAM!");

        Scanner sc = new Scanner(System.in);

        TicketServiceImpl ticketService = new TicketServiceImpl();
        BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
        EventServiceImpl eventService = new EventServiceImpl();

        // ovo se moze zaminit kasnije s nekom mapon/listom od svih mogucih eventa koji postoje / ili svi eventi koji su u bookingu napravljeni)
        // ili kad korisnik zeli ispisat sve bookinge koje je napravia onda da bude u obliku mape

        /*
        List<Event> events = new ArrayList<>(3);
        events.add(new CarMeet("Meet na Crnom!",LocalDateTime.parse("19.02.2026. 19:00", format)));
        events.add(new MoviePremiere("Premijera 'Fiume o Morte!' ",LocalDateTime.parse("25.07.2025. 15:00", format)));
        events.add(new Concert("Bow to None Tour", LocalDateTime.parse("29.07.2024. 19:00", format),"Suffocation", "Death metal"));

        for(Event e : events){
            if( e instanceof Concert concert ){
                concert.getEventType();
            }
        }
        */

        System.out.println("Dobrodošli u EventPlanner Hrvatska!");

        String choice;
        do {
            System.out.println("Želite li unijeti događaj? (y/n)");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                eventService.createEvent(sc);
            }

        } while (choice.equalsIgnoreCase("y"));


        List<Booking> bookings = bookingServiceImpl.generateBookings(sc, ticketService, eventService);

            System.out.println("Ukupna cijena svih bookinga je: " + BookingUtil.totalPrice(bookings));

            System.out.print("Želite li najveću ili najmanju cijenu? (MAX/MIN): ");
            String answer = sc.nextLine();


            // dodat mozda lambdu za ovo
            if ("MAX".equalsIgnoreCase(answer)) {
                System.out.println("Booking s najvećom cijenom: " + BookingUtil.maxBooking(bookings));

            } else if ("MIN".equalsIgnoreCase(answer)) {
                System.out.println("Booking s najMANJOM cijenom: " + BookingUtil.minBooking(bookings));
            }
            else {
                System.out.println("Krivi upit!");
            }

            System.out.print("Unesite ID: ");
            System.out.println( bookingServiceImpl.bookingSearch(bookings, sc) );
    }
}