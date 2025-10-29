package tvz.java.vjezbe.entities;
// upitan interface, mozda bolje napravit neki za bookingIdGenerator???? mozda????

public sealed interface EventState permits Events{
    default void soldOut(){
        System.out.println("Događaj je rasprodan!");
    }
    default void cancelled(){
        System.out.println("Događaj je otkazan!");
    }
    default void bookable(){
        System.out.println("Događaj je dostupan za bookiranje");
    }
}
