package tvz.java.vjezbe.entities;
import java.math.BigDecimal;

public class Ticket {
    private Events event;
    private BigDecimal price;

    public Ticket(Events event, BigDecimal price) {
        this.event = event;
        this.price = price;

    }

    public void setEvent(Events event) {
        this.event = event;
    }

    public Events getEvent() {
        return event;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}