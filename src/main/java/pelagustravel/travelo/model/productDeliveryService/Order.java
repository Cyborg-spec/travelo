package pelagustravel.travelo.model.productDeliveryService;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pelagustravel.travelo.model.ticketSellingService.Airplane;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_")
@Data
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "order_id_gen")
    @SequenceGenerator(name = "order_id_gen",sequenceName = "order_id_seq",allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_office_id")
    private PostOffice postOffice;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "is_delivered")
    private boolean isDelivered;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "order")
    private OrderDetails orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
