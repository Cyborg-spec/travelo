package pelagustravel.travelo.service.productDeliveryService.orderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;
import pelagustravel.travelo.repository.productDeliveryRepitory.OrderDetailsRepository;

import java.util.Optional;

@Service
@Transactional
public class OrderDetailsImpl implements OrderDetailsService{
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public Optional<OrderDetails> findById(long id) {
        return orderDetailsRepository.findById(id);
    }

    @Override
    public void save(OrderDetails orderDetails) {
        orderDetailsRepository.save(orderDetails);
    }
}
