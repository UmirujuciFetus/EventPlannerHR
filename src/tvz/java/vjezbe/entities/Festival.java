package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class Festival extends Events{
    public Festival(String eventName, LocalDateTime eventDate) {
        super(eventName, eventDate);
    }

    @Override
    public void getEventType() {
        System.out.println("Događaj je festival");
    }

    @Override
    public String getStringForm() {
        return "Ime festivala: " + eventName + "\n Datum i vrijeme festivala: " + eventDate;

    }
}
