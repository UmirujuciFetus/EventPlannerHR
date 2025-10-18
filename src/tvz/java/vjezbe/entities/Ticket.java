package tvz.java.vjezbe.entities;
import java.math.BigDecimal;

public class Ticket {
    private Concert concert;
    private BigDecimal price;
    private Integer ticketID;

    public Ticket(Concert concert, BigDecimal price, Integer ticketID){
        this.concert = concert;
        this.price = price;
        this.ticketID = ticketID;
    }

    public void setConcert(Concert concert){
        this.concert = concert;
    }
    public Concert getConcert(){
        return concert;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public BigDecimal getPrice(){
        return price;
    }

    public void setTicketID(Integer ticketID){
        this.ticketID = ticketID;
    }
    public Integer getTicketID(){
        return ticketID;
    }
}