package pelagustravel.travelo.service.productDeliveryService.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.productDeliveryService.Order;
import pelagustravel.travelo.repository.productDeliveryRepitory.OrderRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Set<Order> findByAirplane_AirplaneId(long id) {
        return orderRepository.findByAirplane_AirplaneId(id);
    }
}
