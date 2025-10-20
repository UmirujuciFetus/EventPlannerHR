package tvz.java.vjezbe.entities;
import java.math.BigDecimal;

public class Ticket {
    private Concert concert;
    private BigDecimal price;

    public Ticket(Concert concert, BigDecimal price) {
        this.concert = concert;
        this.price = price;

    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}