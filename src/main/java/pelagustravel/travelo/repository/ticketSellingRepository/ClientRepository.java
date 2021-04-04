package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
