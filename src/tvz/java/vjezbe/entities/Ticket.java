package tvz.java.vjezbe.entities;
import java.math.BigDecimal;

public class Ticket {
    private Event event;
    private BigDecimal price;

    public Ticket(Event event, BigDecimal price) {
        this.event = event;
        this.price = price;

    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}