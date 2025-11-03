package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

/**
 * Predstavlja događaje koji se mogu bookirati.
 *
 * <p>Apstraktna klasa koju nasljeđuju sve ostale klase koje su događaji.
 * Svi oni imaju parametre {@code eventName} i {@code eventDate}.</p>

 *
 * @author Karlo Uskok
 * @version 1.0
 */
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


    /**
     * Vraća tip događaja.
     *
     * <p>
     * Pri pozivanju ove metode nad objektima klasa koji su nasljedili {@code Event},
     * ispisuje se tip eventa.
     * </p>
     */
    public abstract void getEventType();

    /**
     * Vraća string oblik objekta.
     *
     * @return string oblik objekta
     */
    public abstract String getStringForm();

}
