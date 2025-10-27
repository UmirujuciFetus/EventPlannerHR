package tvz.java.vjezbe.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Scanner;

import tvz.java.vjezbe.entities.*;

public class Main {

    public static final Integer NUMBER_OF_USERS = 2;

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Dobrodošli u EventPlanner Hrvatska!\nŽelite li organizirati događanja i korisnike?");

        Booking searched;
        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");

        Events[] events =  {new Festival("Woodstock", LocalDateTime.parse("20.08.1975. 18:00", format))};
        if ("DA".equals(sc.nextLine())) {
            Booking[] bookings = generateBookings(sc);


            System.out.println("Ukupna cijena svih bookinga je: " + totalBookingPrice(bookings));


            System.out.print("Želite li najveću ili najmanju cijenu? (MAX/MIN): ");
            String answer = sc.nextLine();

            if ("MAX".equals(answer)) {
                Booking maxBooking = calculateMaxBooking(bookings);
                System.out.println("Booking s najvećom cijenom: " + maxBooking);

            } else if ("MIN".equals(answer)) {
                Booking minBooking = calculateMinBooking(bookings);
                System.out.println("Booking s najMANJOM cijenom: " + minBooking);
            }
            else {
                System.out.println("Krivi upit!");
            }

            System.out.print("Unesite ID: ");
            searched = Booking.bookingSearch(bookings, sc);
            if(searched != null){
                System.out.println(searched);
            }


        }


    }


    private static Booking[] generateBookings(Scanner sc) {

        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
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

            Events concert = new Concert(eventName,eventDateTime, concertName, concertGenre);

            System.out.println("Unesite cijenu " + (i + 1) + ". ulaznice");
            BigDecimal price = sc.nextBigDecimal();

            System.out.println("Unesite ID " + (i + 1) + ". bookinga");
            Integer id = sc.nextInt();

            sc.nextLine();

            Ticket ticket = new Ticket(concert, price);

            Booking newBooking = new Booking(user, ticket, id);

            bookings[i] = newBooking;

        }
        return bookings;
    }

    private static BigDecimal totalBookingPrice(Booking[] bookings) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Booking elem : bookings) {
            sum = sum.add(elem.getTickets().getPrice());
        }
        return sum;
    }

    private static Booking calculateMaxBooking(Booking[] bookings) {
        if (bookings == null || bookings.length == 0) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking maxBookingPrice = bookings[0];
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(maxBookingPrice.getTickets().getPrice()) > 0) {
                maxBookingPrice = elem;
            }
        }
        return maxBookingPrice;
    }

    private static Booking calculateMinBooking(Booking[] bookings) {
        if (bookings == null || bookings.length == 0) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking minBooking= bookings[0];
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(minBooking.getTickets().getPrice()) < 0) {
                minBooking = elem;
            }
        }
        return minBooking;
    }
}






