package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Seat;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
