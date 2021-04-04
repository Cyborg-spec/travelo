package pelagustravel.travelo.model.productDeliveryService;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "product_id_gen")
    @SequenceGenerator(name = "product_id_gen",sequenceName = "product_id_seq",allocationSize = 1)
    private long productId;

    @Column(name = "weight")
    private long weight;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "product",fetch = FetchType.LAZY)
    OrderDetails orderDetailsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
