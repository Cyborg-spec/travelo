package pelagustravel.travelo.service.productDeliveryService.order;

import pelagustravel.travelo.model.productDeliveryService.Order;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderService {
    Optional<Order>findById(long id);
    void save(Order order);
    Set<Order> findByAirplane_AirplaneId(long id);
}
