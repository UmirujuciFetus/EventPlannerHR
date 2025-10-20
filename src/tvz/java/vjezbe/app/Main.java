package tvz.java.vjezbe.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Scanner;

import tvz.java.vjezbe.entities.Concert;
import tvz.java.vjezbe.entities.Ticket;
import tvz.java.vjezbe.entities.User;
import tvz.java.vjezbe.entities.Booking;

public class Main {

    public static final Integer NUMBER_OF_USERS = 2;

    static void main() {

        Scanner sc = new Scanner(System.in);


        System.out.println("Dobrodošli u EventPlanner Hrvatska!");
        System.out.println("Želite li organizirati događanja i korisnike?");

        Booking searched = null;
        if ("DA".equals(sc.nextLine())) {
            Booking[] bookings = generateBookings(sc);


            System.out.println("Ukupna cijena svih bookinga je: " + totalBookingPrice(bookings));


            System.out.print("Želite li najveću ili najmanju cijenu? (MAX/MIN): ");
            String answer = sc.nextLine();

            if ("MAX".equals(answer)) {
                Booking maxBooking = calculateMaxBooking(bookings);
                System.out.println("Booking s najvećom cijenom: ");
                System.out.println("Booking ID: " + maxBooking.getBookingID());
                System.out.println("Ime i prezime korisnika: " + maxBooking.getUser().getFirstName() + " " + maxBooking.getUser().getLastName());
                System.out.println("Email korisnika:  " + maxBooking.getUser().getEmail());
                System.out.println("Ime i datum koncerta: " + maxBooking.getTickets().getConcert().getConcertName() + " " + maxBooking.getTickets().getConcert().getConcertDateTime());
            } else if ("MIN".equals(answer)) {
                Booking minBooking = calculateMinBooking(bookings);
                System.out.println("Booking s najMANJOM cijenom: ");
                System.out.println("Booking ID: " + minBooking.getBookingID());
                System.out.println("Ime i prezime korisnika: " + minBooking.getUser().getFirstName() + " " + minBooking.getUser().getLastName());
                System.out.println("Email korisnika:  " + minBooking.getUser().getEmail());
                System.out.println("Ime i datum koncerta" + minBooking.getTickets().getConcert().getConcertName() + " " + minBooking.getTickets().getConcert().getConcertDateTime());
            }

            System.out.print("Unesite ID: ");
            searched = Booking.bookingSearch(bookings, sc);
            if(searched != null){
                System.out.println("Booking ID: " + searched.getBookingID());
                System.out.println("Ime i prezime korisnika: " + searched.getUser().getFirstName() + " " + searched.getUser().getLastName());
                System.out.println("Email korisnika:  " + searched.getUser().getEmail());
                System.out.println("Ime i datum koncerta" + searched.getTickets().getConcert().getConcertName() + " " + searched.getTickets().getConcert().getConcertDateTime());
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

            System.out.println("Unesite ime " + (i + 1) + ". koncerta: ");
            String concertName = sc.nextLine();

            System.out.println("Unesite datum " + (i + 1) + ". koncerta: ");
            String datum = sc.nextLine();
            LocalDateTime concertDateTime = LocalDateTime.parse(datum, format);

            Concert concert = new Concert(concertName, concertDateTime);

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
        Booking minBookingPrice = bookings[0];
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(minBookingPrice.getTickets().getPrice()) < 0) {
                minBookingPrice = elem;
            }
        }
        return minBookingPrice;
    }
}






