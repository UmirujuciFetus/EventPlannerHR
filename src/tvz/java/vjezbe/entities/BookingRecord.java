package tvz.java.vjezbe.entities;

public record BookingRecord(
        User user,
        Ticket tickets,
        Integer bookingID
) {}