package tvz.java.vjezbe.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Scanner;

import tvz.java.vjezbe.entities.*;
import tvz.java.vjezbe.entities.BookingImplementation;
import tvz.java.vjezbe.entities.TicketImplementation;

public class Main {

    public static final Integer NUMBER_OF_USERS = 2;
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TicketImplementation ticketService = new TicketImplementation();
        BookingImplementation bookingService = new BookingImplementation();

        System.out.println("Dobrodošli u EventPlanner Hrvatska!\nŽelite li organizirati događanja i korisnike?");

        Event[] events = new Event[5];
        events[0] = new CarMeet("Meet na Crnom!",LocalDateTime.parse("19.02.2026. 19:00", format));
        events[1] = new MoviePremiere("Premijera 'Fiume o Morte!' ",LocalDateTime.parse("25.07.2025. 15:00", format));
        events[2] = new Festival("Woodstock Festival",LocalDateTime.parse("15.06.1976. 10:00", format));
        events[3] = new Promotions("Promocija Studenata",LocalDateTime.parse("06.11.2025. 13:00", format));
        events[4] = new Concert("Bow to None Tour", LocalDateTime.parse("29.07.2024. 19:00", format),"Suffocation", "Death metal");

        for(Event e : events){ e.getEventType(); }

        if ("DA".equalsIgnoreCase(sc.nextLine())) {

            Booking[] bookings = generateBookings(sc, ticketService);

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


    private static Booking[] generateBookings(Scanner sc, TicketImplementation ticketService) {


        Booking[] bookings = new Booking[NUMBER_OF_USERS];

        for (Integer i = 0; i < NUMBER_OF_USERS; i++) {

            // pokusat nac neki nacin da se sve to u jednoj liniji (pomocu formatiranja inputa)
            // posto u User ima Ticket[] lista, znaci da jedan user moze kupit vise ticketa, stoga imati upit i za to
            // takoder, posto jedan booking ugl radi jedan user, nekako uredit to da se pita input samo jednog usera po bookingu ali da taj user opet moze vise koncerata
            // ideja: napravit format za email i generiranje bookingID
            System.out.println((i + 1) + ". booking");
            System.out.println("Unesite ime korisnika: ");
            String name = sc.nextLine();

            System.out.println("Unesite prezime " + (i + 1) + ". korisnika: ");
            String lastName = sc.nextLine();

            System.out.println("Unesite email " + (i + 1) + ".korisnika: ");
            String email = sc.nextLine();

            User user = new User(name, lastName, email);

            System.out.println("Unesite ime " + (i + 1) + ". događaja/koncerta: ");
            String eventName = sc.nextLine();

            System.out.println("Unesite ime " + (i + 1) + ". izvođača: ");
            String concertName = sc.nextLine();

            System.out.println("Unesite datum " + (i + 1) + ". događaja/koncerta: ");
            String datum = sc.nextLine();
            LocalDateTime eventDateTime = LocalDateTime.parse(datum, format);

            System.out.println("Unesite žanr " + (i + 1) + ". izvođača: ");
            String concertGenre = sc.nextLine();

            Event concert = new Concert.ConcertBuilder()
                    .artistName(concertName)
                    .concertGenre(concertGenre)
                    .eventName(eventName)
                    .eventDateTime(eventDateTime)
                    .build();


            BigDecimal price = ticketService.setTicketPrice(sc, (i+1));

            System.out.println("Unesite ID " + (i + 1) + ". bookinga");
            Integer id = sc.nextInt();

            sc.nextLine();

            Ticket ticket = new Ticket(concert, price);

            Booking newBooking = new Booking(user, ticket, id);

            bookings[i] = newBooking;

        }
        return bookings;
    }



}






