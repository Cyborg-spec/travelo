package pelagustravel.travelo.service.ticketSellingService.ticket;

import pelagustravel.travelo.model.ticketSellingService.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TicketService {
    Optional<Ticket> findById(long id);
    Ticket findByClient_ClientIdAndTicketId(long clientId,long ticketId);
    void deleteTicket(Ticket ticket);
    void save(Ticket ticket);
    Ticket findBySeatId(long id);
    Set<Ticket> availableTickets();
}
