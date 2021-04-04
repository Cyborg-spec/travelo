package pelagustravel.travelo.repository.productDeliveryRepitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.productDeliveryService.Order;

import java.util.List;
import java.util.Set;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Set<Order> findByAirplane_AirplaneId(long id);
}
