package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.*;
import tvz.java.vjezbe.exceptions.InvalidEmailException;
import tvz.java.vjezbe.exceptions.InvalidUserInputException;
import tvz.java.vjezbe.exceptions.NegativePriceException;
import tvz.java.vjezbe.validator.EmailValidator;
import tvz.java.vjezbe.validator.InputValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import static tvz.java.vjezbe.app.Main.*;

public class BookingServiceImpl implements BookingService {

    @Override
    public List<Booking> generateBookings(Scanner sc, TicketServiceImpl ticketService, EventServiceImpl eventService) {
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
                    logger.warn("Validacija imena neuspješna: {}", ex.getMessage()); //uredit da se vidi sto je upisano
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

            System.out.println("Unesite ID " + (i + 1) + ". bookinga");
            Integer id = sc.nextInt();
            sc.nextLine();

            var event = chooseUserEvent(eventService, sc);

            Ticket ticket = new Ticket(event, price);
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

    //vjv napravit metodu koji od odabranih tipova dogadaja za dodat korisniku ( jer moze bit razlicitih koncerata)
    @Override
    public Event chooseUserEvent(EventServiceImpl eventService,Scanner sc){
        System.out.println("ODABERI TIP DOGAĐAJA KOJI JE KORISNIK ODABRAO:");
        System.out.println("1) Koncert\n2) Premijera filma\n3) Car meet");

        return switch (sc.nextInt()) {
            case 1 -> eventService.getAllEvents().stream()
                    .filter(e -> e instanceof Concert)
                    .map(e -> (Concert) e)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Ne postoji događaj tog tipa!"));

            case 2 -> eventService.getAllEvents().stream()
                    .filter(e -> e instanceof CarMeet)
                    .map(e -> (CarMeet) e)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Ne postoji događaj tog tipa!"));

            case 3 -> eventService.getAllEvents().stream()
                    .filter(e -> e instanceof MoviePremiere)
                    .map(e -> (MoviePremiere) e)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Ne postoji događaj tog tipa!"));

            default -> throw new IllegalArgumentException("Neispravna opcija odabrana!");
        };
    }
}
