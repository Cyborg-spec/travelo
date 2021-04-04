package pelagustravel.travelo.service.productDeliveryService.orderDetails;

import pelagustravel.travelo.model.productDeliveryService.OrderDetails;

import java.util.Optional;

public interface OrderDetailsService {
    Optional<OrderDetails>findById(long id);
    void save(OrderDetails orderDetails);
}
