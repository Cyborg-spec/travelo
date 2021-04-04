package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.orderDetails.OrderDetailsDTO;
import pelagustravel.travelo.exceptions.OrderDetails.OrderDetailsNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;
import pelagustravel.travelo.service.productDeliveryService.orderDetails.OrderDetailsService;

import java.util.Optional;

@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/orderDetails/{id}")
    public OrderDetailsDTO orderDetails(@PathVariable long id) throws OrderDetailsNotFoundException {
        Optional<OrderDetails>orderDetails=orderDetailsService.findById(id);
        if(orderDetails.isPresent()){
            return entityToDTOConverter.orderDetailsToOrderDetailsDTO(orderDetails.get());
        }else {
            throw new OrderDetailsNotFoundException("Order details not found");
        }
    }
}
