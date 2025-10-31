package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class Festival extends Event {
    public Festival(String eventName, LocalDateTime eventDate) {
        super(eventName, eventDate);
    }

    @Override
    public void getEventType() {
        System.out.println("Ovaj događaj je festival!");
    }

    @Override
    public String getStringForm() {
        return "Ime festivala: " + eventName + "\n Datum i vrijeme festivala: " + eventDate;

    }
}
