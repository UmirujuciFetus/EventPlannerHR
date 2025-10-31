package tvz.java.vjezbe.entities;

import java.math.BigDecimal;
import java.util.Scanner;

public class BookingImplementation implements BookingInterface {

    public BigDecimal totalBookingPrice(Booking[] bookings) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Booking elem : bookings) {
            sum = sum.add(elem.getTickets().getPrice());
        }
        return sum;
    }

    public Booking calculateMaxBooking(Booking[] bookings) {
        if (bookings == null || bookings.length == 0) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking maxBookingPrice = bookings[0];
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(maxBookingPrice.getTickets().getPrice()) > 0) {
                maxBookingPrice = elem;
            }
        }
        return maxBookingPrice;
    }

    public Booking calculateMinBooking(Booking[] bookings) {
        if (bookings == null || bookings.length == 0) {
            System.out.println("Nema podataka o bookinzima!");
            return null;
        }
        Booking minBooking= bookings[0];
        for (Booking elem : bookings) {
            if (elem.getTickets().getPrice().compareTo(minBooking.getTickets().getPrice()) < 0) {
                minBooking = elem;
            }
        }
        return minBooking;
    }


    public BookingRecord bookingSearch(Booking[] bookings, Scanner sc){
        Integer searchID = sc.nextInt();

        if(bookings != null && bookings.length > 0){
            for(Integer i =0;i<bookings.length;i++){
                if(bookings[i].getBookingID().equals(searchID)){
                    return new BookingRecord(bookings[i].getUser(), bookings[i].getTickets(), bookings[i].getBookingID());
                }
            }
        }
        System.out.println("Neispravan Booking ID!");
        return null;
    }
}
