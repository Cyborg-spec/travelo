package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pelagustravel.travelo.dto.OrderDTO;
import pelagustravel.travelo.dto.orderDetails.NewOrderDetailsDTO;
import pelagustravel.travelo.exceptions.Airplane.NoAvailableAirplaneException;
import pelagustravel.travelo.exceptions.Order.OrderNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.productDeliveryService.Order;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;
import pelagustravel.travelo.model.productDeliveryService.Product;
import pelagustravel.travelo.model.ticketSellingService.Airplane;
import pelagustravel.travelo.model.ticketSellingService.Country;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.service.ticketSellingService.country.CountryService;
import pelagustravel.travelo.service.ticketSellingService.flight.FlightService;
import pelagustravel.travelo.service.productDeliveryService.order.OrderService;
import pelagustravel.travelo.service.productDeliveryService.orderDetails.OrderDetailsService;
import pelagustravel.travelo.service.productDeliveryService.postOffice.PostOfficeService;
import pelagustravel.travelo.service.productDeliveryService.product.ProductService;

import java.time.LocalDate;
import java.util.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @Autowired
    private PostOfficeService postOfficeService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private FlightService flightService;

    @GetMapping("/order/{id}")
    public OrderDTO getOrderById(@PathVariable long id) throws OrderNotFoundException {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            return entityToDTOConverter.orderToOrderDTO(order.get());
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }

    @PostMapping("/order/newOrder")
    public String createNewOrder(@RequestBody NewOrderDetailsDTO newOrderDetailsDTO) throws NoAvailableAirplaneException {

        Airplane availableAirplane=null;

        Country fromCountry = countryService.findByCountryName(newOrderDetailsDTO.getFromCountry());
        Country toCountry = countryService.findByCountryName(newOrderDetailsDTO.getToCountry());

        long price = (newOrderDetailsDTO.getProductWeight() / 2) * newOrderDetailsDTO.getQuantity();
        long quantity = newOrderDetailsDTO.getQuantity();
        long productWeight = newOrderDetailsDTO.getProductWeight();

        Set<Flight> flights = flightService.findByFromCountryAndToCountry(fromCountry, toCountry);
        Set<Airplane> airplanes = new HashSet<>();

        for (Flight flight : flights) {
            airplanes.add(flight.getAirplane());
        }

        //finding available airplane for order

        for (Airplane airplane : airplanes) {
            long currentOrdersWeightInAirplane=0;
            Set<Order> orders = airplane.getOrders();
            for (Order order : orders) {
                OrderDetails orderDetails = order.getOrderDetails();
                currentOrdersWeightInAirplane+=(orderDetails.getProduct().getWeight())*(orderDetails.getQuantity());
            }
            if(currentOrdersWeightInAirplane+(productWeight*quantity)<=airplane.getProductsMaxWeight()){
                availableAirplane=airplane;
                break;
            }
        }

        if(availableAirplane!=null) {
            String postOfficeName=newOrderDetailsDTO.getPostOfficeName();
            PostOffice postOffice = postOfficeService.findByPostOfficeName(postOfficeName);

            if(postOffice==null){
                postOffice=new PostOffice();
                postOffice.setPostOfficeName(postOfficeName);
                postOfficeService.save(postOffice);
            }

            Order order = new Order();
            LocalDate localDate = LocalDate.now();
            order.setOrderDate(localDate);
            order.setDelivered(false);
            order.setPostOffice(postOffice);
            order.setAirplane(availableAirplane);
            orderService.save(order);

            Product product = new Product();
            product.setWeight(productWeight);
            productService.save(product);

            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setPrice(price);
            orderDetails.setProduct(product);
            orderDetails.setOrder(order);
            orderDetails.setToCountry(toCountry);
            orderDetails.setFromCountry(fromCountry);
            orderDetails.setQuantity(quantity);
            orderDetailsService.save(orderDetails);

            return "Order saved";
        }else {
            throw new NoAvailableAirplaneException("There are no available airplane for order");
        }
    }
}
