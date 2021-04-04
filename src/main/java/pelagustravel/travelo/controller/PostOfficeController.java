package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.OrderDTO;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.productDeliveryService.Order;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;
import pelagustravel.travelo.service.productDeliveryService.postOffice.PostOfficeService;

import java.util.Optional;
import java.util.Set;

@RestController
public class PostOfficeController {
    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/post_office/{id}/orders")
    public Set<OrderDTO> getPostOfficeOrders(@PathVariable long id){
        //TODO change null pointer exception
        Optional<PostOffice>postOffice=postOfficeService.findById(id);
        if(postOffice.isPresent()) {
            Set<Order> orders =postOffice.get().getOrders();
            return entityToDTOConverter.orderToOrderDTO(orders);
        }else {
            throw new NullPointerException();
        }
    }
}
