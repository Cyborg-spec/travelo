package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.client.ClientDTO;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.seat.SeatService;
import pelagustravel.travelo.service.ticketSellingService.ticket.TicketService;

@RestController
public class SeatController {
    @Autowired
    SeatService seatService;

    @Autowired
    TicketService ticketService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/seat/{id}/client")
    public ClientDTO clientPlace(@PathVariable long id){
        Ticket ticket=ticketService.findBySeatId(id);
        return entityToDTOConverter.clientToClientDTO(ticket.getClient());
    }
}
