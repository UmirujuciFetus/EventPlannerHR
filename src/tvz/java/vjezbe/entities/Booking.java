package tvz.java.vjezbe.entities;
import java.util.Scanner;

public class Booking {
    private User user;
    private Ticket tickets;
    private Integer bookingID;


    public Booking(User user, Ticket tickets, Integer bookingID) {
        this.user = user;
        this.tickets = tickets;
        this.bookingID = bookingID;

    }

    public void  setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return user;
    }

    public void setTickets(Ticket tickets){
        this.tickets = tickets;
    }
    public Ticket getTickets(){
        return tickets;
    }

    public void setBookingID(Integer bookingID){
        this.bookingID = bookingID;
    }
    public Integer getBookingID(){
        return bookingID;
    }



    // tu je moguce napravit downcasting i instanceof, jer triba pristupit nizem objektu preko eventa
    // za laksi kod i manje dodavanja stvari kasnije, mozda bolje napravit abstraktnu metodu u events -
    // - kako bi u svakoj podklasi mogli override i napravit ka mini toString i onda je samo dodat u ovaj toString
    @Override
    public String toString() {
        Event event = tickets.getEvent();
        return "Booking ID: " + bookingID + "\nIme i prezime korisnika: " + user.getFirstName() + " " + user.getLastName()
                + "\nE-mail korisnika: " + user.getEmail() + "\nDatum i vrijeme koncerta: "
                + tickets.getEvent().getEventDate() + "\n" + event.getStringForm();
    }

}

