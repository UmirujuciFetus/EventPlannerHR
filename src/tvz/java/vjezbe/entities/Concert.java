package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

public class Concert extends Event {
    private String artistName;
    private String concertGenre;

    public Concert(String eventName, LocalDateTime eventDate, String artistName, String concertGenre) {
        super(eventName,eventDate);
        this.artistName = artistName;
        this.concertGenre = concertGenre;
    }

    public Concert(ConcertBuilder concertBuilder) {
        super(concertBuilder.eventName, concertBuilder.eventDateTime);
        this.artistName = concertBuilder.artistName;
        this.concertGenre = concertBuilder.concertGenre;
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

    public static class ConcertBuilder{
        private String eventName;
        private LocalDateTime eventDateTime;
        private String artistName;
        private String concertGenre;


        public ConcertBuilder artistName(String artistName){
            this.artistName = artistName;
            return this;
        }
        public ConcertBuilder concertGenre(String concertGenre){
            this.concertGenre = concertGenre;
            return this;
        }
        public ConcertBuilder eventName(String eventName){
            this.eventName = eventName;
            return this;
        }
        public ConcertBuilder eventDateTime(LocalDateTime eventDateTime){
            this.eventDateTime = eventDateTime;
            return this;
        }

        public Concert build(){
            return new Concert(this);
        }
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