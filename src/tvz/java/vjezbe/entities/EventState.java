package tvz.java.vjezbe.entities;

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
