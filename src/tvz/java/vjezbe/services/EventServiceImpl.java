package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.Event;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SequencedSet;
import java.util.TreeSet;

public class EventServiceImpl implements EventService {

    SequencedSet<Event> events = new TreeSet<>(Comparator.comparing(Event::getEventDate));

    @Override
    public void createEvent(Scanner sc) {

        System.out.println("Želite li dodati novi događaj? (y/n)");

    }
}
