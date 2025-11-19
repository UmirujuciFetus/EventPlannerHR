package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class MoviePremiere extends Event {
    private String title;
    private String description;



    public MoviePremiere(String eventName, LocalDateTime eventDate,  String title, String description) {
        super(eventName, eventDate);
        this.title = title;
        this.description = description;
    }

    public void setMovieTitle(String title){
        this.title = title;
    }
    public String getMovieTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
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
