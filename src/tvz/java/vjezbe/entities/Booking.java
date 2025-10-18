package tvz.java.vjezbe.entities;

public class Booking {
    private User user;
    private Ticket[] tickets;
    private String status;
    private Integer bookingID;

    public Booking(User user, Ticket[] tickets, String status, Integer bookingID) {
        this.user = user;
        this.tickets = tickets;
        this.status = status;
        this.bookingID = bookingID;
    }

    public void  setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }

    public void setTickets(Ticket[] tickets){
        this.tickets = tickets;
    }
    public Ticket[] getTickets(){
        return tickets;
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

    public void setBookingID(Integer bookingID){
        this.bookingID = bookingID;
    }
    public Integer getBookingID(){
        return bookingID;
    }

}

