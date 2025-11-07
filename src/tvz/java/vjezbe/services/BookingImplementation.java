package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.*;
import tvz.java.vjezbe.exceptions.InvalidEmailException;
import tvz.java.vjezbe.exceptions.InvalidUserInputException;
import tvz.java.vjezbe.exceptions.NegativePriceException;
import tvz.java.vjezbe.validator.EmailValidator;
import tvz.java.vjezbe.validator.InputValidator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static tvz.java.vjezbe.app.Main.*;

public class BookingImplementation implements BookingInterface {

    @Override
    public BigDecimal totalBookingPrice(List<Booking> bookings) {
        BigDecimal sum = BigDecimal.ZERO;
        for(Booking b : bookings) {
            sum = sum.add(b.getTickets().getPrice());
        }
        return sum;
    }

    @Override
    public Booking calculateMaxBooking(List<Booking> bookings) {
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking maxBooking = bookings.getFirst();
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(maxBooking.getTickets().getPrice()) > 0) {
                maxBooking = elem;
            }
        }
        return maxBooking;
    }

    @Override
    public Booking calculateMinBooking(List<Booking> bookings) {
        if (bookings == null || bookings.isEmpty()) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking minBooking= bookings.getFirst();
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(minBooking.getTickets().getPrice()) < 0) {
                minBooking = elem;
            }
        }
        return minBooking;
    }

    @Override
    public List<Booking> generateBookings(Scanner sc, TicketImplementation ticketService) {
        List<Booking> bookings = new ArrayList<>(NUMBER_OF_USERS);

        for (Integer i = 0; i < NUMBER_OF_USERS; i++) {

            InputValidator inputValidator = new InputValidator();
            EmailValidator emailValidator = new EmailValidator();

            String name = "", lastName ="", email ="";
            BigDecimal price;


            // posto u User ima Ticket[] lista, znaci da jedan user moze kupit vise ticketa, stoga imati upit i za to
            // takoder, posto jedan booking ugl radi jedan user, nekako uredit to da se pita input samo jednog usera po bookingu ali da taj user opet moze vise koncerata
            // ideja:generiranje bookingID
            System.out.println((i + 1) + ". booking");

            do {
                try {
                    System.out.println("Unesite ime " + (i + 1) + ". korisnika: ");
                    name = inputValidator.validateName(sc);
                    logger.info("Uneseno ime za korisnika: {}", name);
                } catch (InvalidUserInputException ex) {
                    logger.warn("Validacija imena neuspješna: {}", ex.getMessage());
                }
            }while(name.isEmpty());


            do{
                try{
                    System.out.println("Unesite prezime" + (i + 1) + ". korisnika: ");
                    lastName = inputValidator.validateLastName(sc);
                    logger.info("Uneseno prezime za korisnika: {}", lastName);
                }
                catch (InvalidUserInputException ex) {
                    logger.warn("Validacija prezimena neuspješna: {}", ex.getMessage());
                }
            }while(lastName.isEmpty());

            do{
                try {
                    System.out.println("Unesite email " + (i + 1) + ". korisnika: ");
                    email = emailValidator.validateEmail(sc);
                    logger.info("Unesen mail za korisnika: {}", email);
                }
                catch(InvalidEmailException ex) {
                    logger.warn("Neuspješna validacija emaila: {}", ex.getMessage());
                }
            }while(email.isEmpty());

            do{
                try{
                    price = ticketService.setTicketPrice(sc, (i + 1));
                    logger.info("Unesena cijena karte: {}", price);
                }
                catch (NegativePriceException ex) {
                    logger.warn("Krivi unos cijene: {}", ex.getMessage());
                    throw new RuntimeException(ex);
                }
            }while(price.compareTo(BigDecimal.ZERO) < 0);



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

            System.out.println("Unesite ID " + (i + 1) + ". bookinga");
            Integer id = sc.nextInt();

            sc.nextLine();

            Ticket ticket = new Ticket(concert, price);
            Booking newBooking = new Booking(user, ticket, id);

            bookings.add(newBooking);


        }
        return bookings;
    }


    @Override
    public BookingRecord bookingSearch(List<Booking> bookings, Scanner sc){
        Integer searchID = sc.nextInt();

        if(bookings != null && !bookings.isEmpty()){
            for(Booking booking : bookings){
                if(booking.getBookingID().equals(searchID)){
                    return new BookingRecord(booking.getUser(), booking.getTickets(), booking.getBookingID());
                }
            }
        }
        System.out.println("Neispravan Booking ID!");
        return null;
    }
}
