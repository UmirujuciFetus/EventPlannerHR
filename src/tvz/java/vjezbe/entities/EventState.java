package tvz.java.vjezbe.entities;

public sealed interface EventState permits Events {
    void soldOut();
    void book();
}
