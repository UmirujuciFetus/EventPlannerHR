package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class CarMeet extends Event {

    public CarMeet(String eventName, LocalDateTime eventDate) {
        super(eventName, eventDate);
    }

    @Override
    public void getEventType() {
        System.out.println("Ovaj događaj je Car Meet!");
    }

    @Override
    public String getStringForm() {
        return "Ime meeta: " + eventName + "\n Datum i vrijeme meeta: " + eventDate;
    }
}
