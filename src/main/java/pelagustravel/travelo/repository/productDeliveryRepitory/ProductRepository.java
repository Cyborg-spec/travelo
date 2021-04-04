package pelagustravel.travelo.repository.productDeliveryRepitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.productDeliveryService.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
