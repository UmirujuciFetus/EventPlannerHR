package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

public class Concert extends Events {
    private String artistName;
    private String concertGenre;

    public Concert(String eventName, LocalDateTime eventDate, String artistName, String concertGenre) {
        super(eventName,eventDate);
        this.artistName = artistName;
        this.concertGenre = concertGenre;
    }


    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getConcertGenre() {
        return concertGenre;
    }
    public void setConcertGenre(String concertGenre) {
        this.concertGenre = concertGenre;
    }

    @Override
    public void getEventType(){
        System.out.println("Ovaj događaj je koncert!");
    }
    @Override
    public String getStringForm(){
        return "Ime izvođača: "+ getArtistName() + " Žanr koncerta: " + getConcertGenre();
    }

}