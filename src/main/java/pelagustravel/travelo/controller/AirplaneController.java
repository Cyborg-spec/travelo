package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.orderDetails.OrderDetailsDTO;
import pelagustravel.travelo.dto.FlightDTO;
import pelagustravel.travelo.dto.SeatDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.exceptions.Airplane.AirplaneNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.productDeliveryService.Order;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;
import pelagustravel.travelo.model.ticketSellingService.Airplane;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.model.ticketSellingService.Seat;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.airplane.AirplaneService;
import pelagustravel.travelo.service.ticketSellingService.flight.FlightService;

import java.util.*;

@RestController
public class AirplaneController {
    @Autowired
    AirplaneService airplaneService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @Autowired
    FlightService flightService;

    @GetMapping("/airplane/{id}/tickets")
    public Set<Set<TicketDTO>> airplaneClients(@PathVariable long id) throws AirplaneNotFoundException {
        Optional<Airplane>airplane=airplaneService.findById(id);
        if(airplane.isPresent()){
            Set<Flight> flights=airplane.get().getFlights();
            Set<Set<Ticket>>tickets=new HashSet<>();
            for(Flight flight:flights){
                tickets.add(flight.getTickets());
            }
            return entityToDTOConverter.ticketsListsToTicketDTO(tickets);
        }else {
            throw new AirplaneNotFoundException("Airplane with this id not found");
        }

    }
    @GetMapping("/airplane/{id}/seats")
    public Set<SeatDTO> airplaneSeats(@PathVariable long id) throws AirplaneNotFoundException {
        Optional<Airplane>airplane=airplaneService.findById(id);
        if(airplane.isPresent()){
            Set<Seat>seats=airplane.get().getSeatList();
            return entityToDTOConverter.seatToSeatDTO(seats);
        }else {
            throw new AirplaneNotFoundException("Airplane with this id not found");
        }
    }

    @GetMapping("/airplane/{id}/flights")
    public Set<FlightDTO> airplaneFlights(@PathVariable long id) throws AirplaneNotFoundException {
        Optional<Airplane>airplane=airplaneService.findById(id);
        if(airplane.isPresent()){
            Set<Flight>flights=flightService.findByAirplaneId(id);
            return entityToDTOConverter.flightToFLightDTO(flights);
        }else {
            throw new AirplaneNotFoundException("Airplane with this id not found");
        }
    }

    @GetMapping("/airplane/{id}/orders")
    public Set<OrderDetailsDTO> airplaneProducts(@PathVariable long id) throws Exception {
        Optional<Airplane>airplane=airplaneService.findById(id);
        if(airplane.isPresent()){
            Set<Order>orders=airplane.get().getOrders();
            Set<OrderDetails>orderDetails=new HashSet<>();
            for(Order order:orders){
                orderDetails.add(order.getOrderDetails());
            }
            return entityToDTOConverter.orderDetailsToOrderDetailsDTO(orderDetails);
        }else {
            throw new AirplaneNotFoundException("Airplane not found");
        }
    }
}
