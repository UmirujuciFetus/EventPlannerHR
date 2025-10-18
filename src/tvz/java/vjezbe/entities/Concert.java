package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

public class Concert {
    private String concertName;
    private LocalDateTime concertDateTime;
    private String location;

    public Concert(String concertName, Integer id, LocalDateTime concertDateTime, String location) {
        this.concertName = concertName;
        this.concertDateTime = concertDateTime;
        this.location = location;
    }

    //region getteriSetteri
    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }
    public String getConcertName(){
        return concertName;
    }

    public void setConcertDateTime(LocalDateTime concertDateTime){
        this.concertDateTime = concertDateTime;
    }
    public LocalDateTime getConcertDateTime(){
        return concertDateTime;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }
    //endregion
}
