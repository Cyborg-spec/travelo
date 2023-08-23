package pelagustravel.travelo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pelagustravel.travelo.dto.client.ClientDTO;
import pelagustravel.travelo.dto.FlightDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.exceptions.ticket.TicketNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.ticketSellingService.Client;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.ticket.TicketService;

import java.util.Optional;
import java.util.Set;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/ticket/{id}/ticket-owner")
    public ClientDTO getTicketOwner(@PathVariable long id) throws TicketNotFoundException {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            Client client = ticket.get().getClient();
            return entityToDTOConverter.clientToClientDTO(client);
        } else {
            throw new TicketNotFoundException("Ticket with this id not found in database");
        }
    }

    @GetMapping("/ticket/{id}")
    public TicketDTO getTicket(@PathVariable long id) throws TicketNotFoundException {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            return entityToDTOConverter.ticketToTicketDTO(ticket.get());
        } else {
            throw new TicketNotFoundException("Ticket with this id not found in database");
        }
    }

    @GetMapping("ticket/{id}/flight")
    public FlightDTO getFlightByTicketId(@PathVariable long id) throws TicketNotFoundException {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (ticket.isPresent()) {
            Flight flight = ticket.get().getFlight();
            return entityToDTOConverter.flightToFlightDTO(flight);
        } else {
            throw new TicketNotFoundException("Ticket with this id not found in database");
        }
    }
    @DeleteMapping("/ticket/{id}")
    public String deleteTicket(@PathVariable long id) throws TicketNotFoundException {
        Optional<Ticket>ticket=ticketService.findById(id);
        if(ticket.isPresent()){
            ticketService.deleteTicket(ticket.get());
            return "Ticket deleted successfully";
        }else {
            throw new TicketNotFoundException("Ticket with this id not found in database");
        }
    }
    @GetMapping("/ticket/available-tickets")
    public Set<TicketDTO> availableTickets(){
        System.out.println("dfgkdjf");
        return entityToDTOConverter.ticketToTicketDTO(ticketService.availableTickets());
    }

}
