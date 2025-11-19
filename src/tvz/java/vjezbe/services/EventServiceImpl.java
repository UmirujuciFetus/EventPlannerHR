package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.CarMeet;
import tvz.java.vjezbe.entities.Concert;
import tvz.java.vjezbe.entities.Event;
import tvz.java.vjezbe.entities.MoviePremiere;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Scanner;
import java.util.SequencedSet;
import java.util.TreeSet;

import static tvz.java.vjezbe.app.Main.format;

public class EventServiceImpl implements EventService {

    private SequencedSet<Event> events = new TreeSet<>(Comparator.comparing(Event::getEventDate));


    public SequencedSet<Event> getAllEvents(){
        return events;
    }

    @Override
    public void createEvent(Scanner sc) {

        System.out.println("ODABERI TIP DOGAĐAJA:");
        System.out.println("1) Koncert\n2) Premijera filma\n3) Car meet");

        switch(sc.nextInt()){
            case 1 -> events.add(createConcert(sc));
            case 2 -> events.add(createMoviePremiere(sc));
            case 3 -> events.add(createCarMeet(sc));
        }
    }

    @Override
    public Concert createConcert(Scanner sc) {
        sc.nextLine();

        System.out.println("Unesite ime događaja: ");
        String eventName = sc.nextLine();

        System.out.println("Unesite ime izvođača: ");
        String artistName = sc.nextLine();

        System.out.println("Unesite datum koncerta: ");
        String datum = sc.nextLine();
        LocalDateTime eventDateTime = LocalDateTime.parse(datum, format);

        System.out.println("Unesite žanr izvođača: ");
        String concertGenre = sc.nextLine();

        return new Concert.ConcertBuilder()
                .artistName(artistName)
                .concertGenre(concertGenre)
                .eventName(eventName)
                .eventDateTime(eventDateTime)
                .build();
    }

    @Override
    public MoviePremiere createMoviePremiere(Scanner sc) {
        sc.nextLine();
        System.out.println("Unesite ime događaja: ");
        String eventName = sc.nextLine();

        System.out.println("Unesite ime filma: ");
        String movieTitle = sc.nextLine();

        System.out.println("Unesite datum događaja: ");
        String datum = sc.nextLine();
        LocalDateTime eventDateTime = LocalDateTime.parse(datum, format);

        System.out.println("Unesite opis filma: ");
        String movieDescription = sc.nextLine();


        return new MoviePremiere(eventName, eventDateTime, movieTitle, movieDescription);
    }

    @Override
    public CarMeet createCarMeet(Scanner sc){
        sc.nextLine();
        System.out.println("Unesite ime događaja: ");
        String eventName = sc.nextLine();

        System.out.println("Unesite ime car meeta: ");
        String meetName = sc.nextLine();

        System.out.println("Unesite datum događaja: ");
        String datum = sc.nextLine();
        LocalDateTime eventDateTime = LocalDateTime.parse(datum, format);

        System.out.println("Unesite broj registriranih auta na meetu: ");
        Integer numberOfCars = sc.nextInt();

        return new CarMeet(eventName, eventDateTime, meetName, numberOfCars);
    }
}
