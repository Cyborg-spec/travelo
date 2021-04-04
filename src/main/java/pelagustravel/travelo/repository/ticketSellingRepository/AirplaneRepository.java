package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane,Long> {

}
