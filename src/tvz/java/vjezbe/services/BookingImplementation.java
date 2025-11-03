package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.Booking;
import tvz.java.vjezbe.entities.BookingRecord;

import java.math.BigDecimal;
import java.util.Scanner;

public class BookingImplementation implements BookingInterface {

    @Override
    public BigDecimal totalBookingPrice(Booking[] bookings) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Booking elem : bookings) {
            sum = sum.add(elem.getTickets().getPrice());
        }
        return sum;
    }

    @Override
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

    @Override
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


    @Override
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
