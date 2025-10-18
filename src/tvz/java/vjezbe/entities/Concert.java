package tvz.java.vjezbe.entities;
import java.time.LocalDateTime;

public class Concert {
    private String concertName;
    private LocalDateTime concertDateTime;


    public Concert(String concertName, LocalDateTime concertDateTime) {
        this.concertName = concertName;
        this.concertDateTime = concertDateTime;

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
    //endregion
}
