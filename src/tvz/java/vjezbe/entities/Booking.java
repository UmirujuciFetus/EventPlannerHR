package tvz.java.vjezbe.entities;

import java.math.BigDecimal;

import static tvz.java.vjezbe.app.Main.NUMBER_OF_USERS;

public class Booking {
    private User user;
    private Ticket tickets;



    public Booking(User user, Ticket tickets) {
        this.user = user;
        this.tickets = tickets;


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

    public static BigDecimal totalBookingPrice(){
        Booking[] bookings = new Booking[NUMBER_OF_USERS];
        BigDecimal sum = BigDecimal.ZERO;
        for (Booking elem : bookings) {
            sum = sum.add(elem.getTickets().getPrice());

        }
        return sum;
    }



}

