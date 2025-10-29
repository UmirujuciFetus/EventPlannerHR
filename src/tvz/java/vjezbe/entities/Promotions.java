package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class Promotions extends Events{
    public Promotions(String eventName, LocalDateTime eventDate) {
        super(eventName, eventDate);
    }

    @Override
    public void getEventType() {
        System.out.println("Ovaj događaj je promocija!");
    }

    @Override
    public String getStringForm() {
        return "Ime promocije: " + eventName + "\n Datum i vrijeme promocije: " + eventDate;

    }
}
