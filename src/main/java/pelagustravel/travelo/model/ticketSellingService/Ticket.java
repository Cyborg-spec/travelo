package pelagustravel.travelo.model.ticketSellingService;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;

    @Column(name = "ticket_price")
    long ticketPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId);
    }
}
