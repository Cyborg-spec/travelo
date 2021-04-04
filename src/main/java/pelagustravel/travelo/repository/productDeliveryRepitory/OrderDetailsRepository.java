package pelagustravel.travelo.repository.productDeliveryRepitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
