package tvz.java.vjezbe.entities;

import java.math.BigDecimal;
import java.util.Scanner;

import static tvz.java.vjezbe.app.Main.NUMBER_OF_USERS;

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


    public static Booking bookingSearch(Booking[] bookings, Scanner sc){
        String searchID = sc.nextLine();

        for(Integer i =0;i<bookings.length;i++){
            if(bookings[i].getBookingID().equals(searchID)){
                return bookings[i];
            }
        }
        System.out.println("Neispravan Booking ID!");
        return null;
    }

}

