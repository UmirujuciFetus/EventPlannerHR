package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class MoviePremiere extends Events{
    public MoviePremiere(String eventName, LocalDateTime eventDate) {
        super(eventName, eventDate);
    }

    @Override
    public void getEventType() {
        System.out.println("Ovaj događaj je premijera filma!");
    }

    @Override
    public String getStringForm() {
        return "Ime premijere: " + eventName + "\n Datum i vrijeme premijere: " + eventDate;

    }
}
