package pelagustravel.travelo.service.ticketSellingService.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.repository.ticketSellingRepository.TicketRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class TicketServiceImpl implements TicketService{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public Optional<Ticket> findById(long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public Ticket findByClient_ClientIdAndTicketId(long clientId, long ticketId) {
        return ticketRepository.findByClient_ClientIdAndTicketId(clientId,ticketId);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket findBySeatId(long id) {
        return ticketRepository.findBySeatSeatId(id);
    }

    @Override
    public Set<Ticket> availableTickets() {
        return ticketRepository.availableTickets();
    }

}
