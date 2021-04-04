package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pelagustravel.travelo.model.ticketSellingService.Ticket;

import java.util.List;
import java.util.Set;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    Ticket findByClient_ClientIdAndTicketId(long clientId,long ticketId);
    Ticket findBySeatSeatId(long id);
    @Query(value = "SELECT * FROM ticket t WHERE client_id is null",nativeQuery = true)
    Set<Ticket> availableTickets();
}
