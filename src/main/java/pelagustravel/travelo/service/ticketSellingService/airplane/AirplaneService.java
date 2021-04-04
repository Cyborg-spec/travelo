package pelagustravel.travelo.service.ticketSellingService.airplane;

import pelagustravel.travelo.model.ticketSellingService.Airplane;

import java.util.Optional;

public interface AirplaneService {
    Optional<Airplane> findById(long id);
}
