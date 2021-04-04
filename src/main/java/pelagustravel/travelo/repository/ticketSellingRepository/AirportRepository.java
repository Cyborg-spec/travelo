package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Airport;

public interface AirportRepository extends JpaRepository<Airport,Long> {
}
