package tvz.java.vjezbe.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.Scanner;

import tvz.java.vjezbe.entities.Concert;
import tvz.java.vjezbe.entities.Ticket;
import tvz.java.vjezbe.entities.User;
import tvz.java.vjezbe.entities.Booking;

public class Main{
    
    public static final Integer NUMBER_OF_USERS = 2;

    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Dobrodošli u EventPlanner Hrvatska!");
        System.out.println("Želite li organizirati događanja i korisnike?");

        if("DA".equals(sc.nextLine())){
            Booking[] bookings = generateBookings(sc);
            System.out.println("Ukupna cijena cijelog bookinga je: ");
            System.out.println(Booking.totalBookingPrice());
        }
    }

    private static Booking[] generateBookings(Scanner sc){

        final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
        Booking[] bookings = new Booking[NUMBER_OF_USERS];

        for(Integer i = 0; i < NUMBER_OF_USERS; i++ ){

    // pokusat nac neki nacin da se sve to u jednoj liniji (pomocu formatiranja inputa)
    // posto u User ima Ticket[] lista, znaci da jedan user moze kupit vise ticketa, stoga imati upit i za to
    // takoder, posto jedan booking ugl radi jedan user, nekako uredit to da se pita input samo jednog usera po bookingu ali da taj user opet moze vise koncerata
    // ideja: napravit format za email i generiranje bookingID

            System.out.println("Unesite ime "+ (i+1) + ". korisnika: ");
            String name =  sc.nextLine();

            System.out.println("Unesite prezime "+ (i+1) + ". korisnika: ");
            String lastName =  sc.nextLine();

            System.out.println("Unesite email "+ (i+1) + ".korisnika: ");
            String email =  sc.nextLine();

            User user = new User(name, lastName, email);

            System.out.println("Unesite ime "+ (i+1) + ". koncerta: ");
            String concertName =  sc.nextLine();

            System.out.println("Unesite datum "+ (i+1) + ". koncerta: ");
            String datum = sc.nextLine();
            LocalDateTime concertDateTime = LocalDateTime.parse(datum, format);

            Concert concert = new Concert(concertName, concertDateTime);

            System.out.println("Unesite cijenu "+ (i+1) +". koncerta");
            BigDecimal price = sc.nextBigDecimal();

            System.out.println("Unesite ID "+ (i+1) +". koncerta");
            Integer id = sc.nextInt();

            sc.nextLine();

            Ticket ticket = new Ticket(concert, price, id);

            Booking newBooking = new Booking(user, ticket);

            bookings[i] = newBooking;

        }
        return bookings;
    }



}
