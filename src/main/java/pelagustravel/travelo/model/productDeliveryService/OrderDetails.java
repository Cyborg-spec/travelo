package pelagustravel.travelo.model.productDeliveryService;

import lombok.Data;
import pelagustravel.travelo.model.ticketSellingService.Country;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_details")
@Data
public class OrderDetails {
    @Id
    @Column(name = "order_details_id")
    @GeneratedValue(generator = "order_details_id_gen")
    @SequenceGenerator(name = "order_details_id_gen",sequenceName = "order_details_id_seq",allocationSize = 1)
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_country",referencedColumnName = "country_id")
    private Country fromCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_country",referencedColumnName = "country_id")
    private Country toCountry;

    @Column(name = "price")
    private long price;

    @Column(name = "quantity")
    private long quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
