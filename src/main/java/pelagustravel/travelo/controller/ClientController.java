package pelagustravel.travelo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pelagustravel.travelo.dto.client.ClientDTO;
import pelagustravel.travelo.dto.SeatDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.dto.client.ClientDTOWhenClientBuysTicket;
import pelagustravel.travelo.exceptions.client.ClientNotFoundException;
import pelagustravel.travelo.exceptions.client.NotEnoughAmountInCardException;
import pelagustravel.travelo.exceptions.ticket.AllSelectedTicketsBoughtException;
import pelagustravel.travelo.mappers.DTOtoEntityConverter;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.ticketSellingService.Client;
import pelagustravel.travelo.model.ticketSellingService.Seat;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.airport.AirportService;
import pelagustravel.travelo.service.ticketSellingService.client.ClientService;
import pelagustravel.travelo.service.ticketSellingService.ticket.TicketService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    TicketService ticketService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @Autowired
    DTOtoEntityConverter dtoToEntityConverter;

    @Autowired
    AirportService airportService;

    @GetMapping("/client/{id}/client-tickets")
    public Set<TicketDTO> getAllClientTickets(@PathVariable long id) throws ClientNotFoundException {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            Set<Ticket> tickets = client.get().getTickets();
            return entityToDTOConverter.ticketToTicketDTO(tickets);
        } else {
            throw new ClientNotFoundException("Client with this id not found in database");
        }
    }

    @GetMapping("/client/{id}")
    public ClientDTO getClient(@PathVariable long id) throws ClientNotFoundException {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            return entityToDTOConverter.clientToClientDTO(client.get());
        } else {
            throw new ClientNotFoundException("Client with this id not found in database");
        }
    }

    @GetMapping("/client/{id}/{ticketId}/seat")
    public SeatDTO clientSeatInThisTicket(@PathVariable long id, @PathVariable long ticketId) {
        Ticket ticket = ticketService.findByClient_ClientIdAndTicketId(id, ticketId);
        Seat seat = ticket.getSeat();
        return entityToDTOConverter.seatToSeatDTO(seat);
    }

    @PostMapping("/client/ticket-buy")
    public Set<TicketDTO> ticketBuy(@RequestBody ClientDTOWhenClientBuysTicket clientDTOWhenClientBuysTicket) throws NotEnoughAmountInCardException, AllSelectedTicketsBoughtException {
        long amountInCard = clientDTOWhenClientBuysTicket.getAmountOnTheCard();
        Set<Integer> ticketsIds = clientDTOWhenClientBuysTicket.getTicketsToBuy();
        long ticketsPrice = 0;
        Set<TicketDTO>boughtTickets=new HashSet<>();
        for (Integer ticketId : ticketsIds) {
            Optional<Ticket> ticket = ticketService.findById(ticketId);
            if (ticket.isPresent()&&ticket.get().getClient()==null) {
                ticketsPrice += ticket.get().getTicketPrice();
            }
        }
        if(ticketsPrice!=0) {
            //Getting client amountInCardFromCard...
            if (amountInCard >= ticketsPrice) {
                Client client = dtoToEntityConverter.clientDtoToClientEntity(clientDTOWhenClientBuysTicket);
                //amountInTheCard-ticketsPrice if we have a real card

                if (clientDTOWhenClientBuysTicket.getAirportId() == 0) {
                    client.setAirport(airportService.findById(1).get());//default value
                }

                clientService.save(client);
                for (Integer ticketId : ticketsIds) {
                    Optional<Ticket> ticket = ticketService.findById(ticketId);
                    if (ticket.isPresent()) {
                        ticket.get().setClient(client);
                        ticketService.save(ticket.get());
                        boughtTickets.add(entityToDTOConverter.ticketToTicketDTO(ticket.get()));
                    }
                }
            } else {
                throw new NotEnoughAmountInCardException("Not enough amount in card");
            }
        }else {
            throw new AllSelectedTicketsBoughtException("All selected tickets already bought");
        }
        return boughtTickets;
    }

    @DeleteMapping("/client/{id}")
    public String deleteClient(@PathVariable long id) throws ClientNotFoundException {
        Optional<Client> client = clientService.findById(id);
        if (client.isPresent()) {
            clientService.delete(client.get());
            return "Client deleted successfully";
        } else {
            throw new ClientNotFoundException("Client with this id not found in database");
        }
    }

}
