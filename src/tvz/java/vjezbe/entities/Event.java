package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

public abstract class Event {
    protected String eventName;
    protected LocalDateTime eventDate;

    Event(String eventName, LocalDateTime eventDate){
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

    public void setEventName(String eventName){
        this.eventName = eventName;
    }
    public String getEventName(){
        return eventName;
    }

    public void setEventDate(LocalDateTime eventDate){
        this.eventDate = eventDate;
    }
    public LocalDateTime getEventDate(){
        return eventDate;
    }



    public abstract void getEventType();
    public abstract String getStringForm();

}
