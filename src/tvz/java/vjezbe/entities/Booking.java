package tvz.java.vjezbe.entities;

import java.util.List;
import java.util.ArrayList;
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


    @Override
    public String toString() {
        Event event = tickets.getEvent();
        return "Booking ID: " + bookingID + "\nIme i prezime korisnika: " + user.getFirstName() + " " + user.getLastName()
                + "\nE-mail korisnika: " + user.getEmail() + "\nDatum i vrijeme koncerta: "
                + tickets.getEvent().getEventDate() + "\n" + event.getStringForm();
    }

}

