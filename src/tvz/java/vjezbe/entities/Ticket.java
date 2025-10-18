package tvz.java.vjezbe.entities;

public class Ticket {
    private Concert concert;
    private Integer price;
    private Integer ticketID;

    public Ticket(Concert concert, Integer price, Integer ticketID){
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

    public void setPrice(Integer price){
        this.price = price;
    }
    public Integer getPrice(){
        return price;
    }

    public void setTicketID(Integer ticketID){
        this.ticketID = ticketID;
    }
    public Integer getTicketID(){
        return ticketID;
    }
}