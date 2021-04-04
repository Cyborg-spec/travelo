package pelagustravel.travelo.repository.ticketSellingRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pelagustravel.travelo.model.ticketSellingService.Ticket;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TicketRepositoryTest {

    @Autowired
    private TicketRepository ticketRepository;

    @AfterEach
    void tearDown() {
         ticketRepository.deleteAll();
    }

    @Test
    void availableTickets() {
        Ticket ticket=new Ticket();
        ticket.setClient(null);
        Set<Ticket> ticketSet=Set.of(ticket);
        ticketRepository.save(ticket);
        assertThat(ticketSet).isEqualTo(ticketRepository.availableTickets());
    }
}