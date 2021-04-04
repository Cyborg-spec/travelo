package pelagustravel.travelo.model.ticketSellingService;

import lombok.Data;
import pelagustravel.travelo.model.productDeliveryService.Order;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airplane")
@Data
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airplane_id")
    private long airplaneId;

    @Column(name = "airplane_name")
    private String airplaneName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airplane")
    private Set<Seat> seatList;

    @Column(name = "products_max_weight")
    private long productsMaxWeight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airplane")
    private Set<Flight> flights;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airplane")
    private Set<Order>orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return airplaneId == airplane.airplaneId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneId);
    }
}
