package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.FlightDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.exceptions.flight.FlightNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.flight.FlightService;

import java.util.Optional;
import java.util.Set;

@RestController
public class FlightController {
    @Autowired
    FlightService flightService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/flight/{id}/tickets")
    public Set<TicketDTO> getAllTicketsByFlightId(@PathVariable long id) throws FlightNotFoundException {
        Optional<Flight>flight=flightService.findById(id);
        if(flight.isPresent()) {
            Set<Ticket> tickets=flight.get().getTickets();
            return entityToDTOConverter.ticketToTicketDTO(tickets);
        }else {
            throw new FlightNotFoundException("Flight with this id not found in database");
        }
    }
    @GetMapping("/flight/{id}")
    public FlightDTO getFlightWithId(@PathVariable long id) throws FlightNotFoundException {
        Optional<Flight>flight=flightService.findById(id);
        if(flight.isPresent())
            return entityToDTOConverter.flightToFlightDTO(flight.get());
        else
            throw new FlightNotFoundException("Flight with this id not found in database");
    }
    @DeleteMapping("/flight/{id}")
    public String deleteFlight(@PathVariable long id) throws FlightNotFoundException {
        Optional<Flight>flight=flightService.findById(id);
        if(flight.isPresent()){
            flightService.deleteFlight(flight.get());
            return "Flight deleted successfully";
        }else {
            throw new FlightNotFoundException("Flight with this id not found in database");
        }
    }
}
