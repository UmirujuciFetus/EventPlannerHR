package tvz.java.vjezbe.entities;

public record Booking(
        User user,
        Ticket tickets,
        Integer bookingID
) {
    @Override
    public String toString(){
        Event event = tickets.getEvent();
        return "Booking ID: " + bookingID + "\nIme i prezime korisnika: " + user.getFirstName() + " " + user.getLastName()
                + "\nE-mail korisnika: " + user.getEmail() + "\nDatum i vrijeme koncerta: "
                + tickets.getEvent().getEventDate() + "\n" + event.getStringForm();
    }
}