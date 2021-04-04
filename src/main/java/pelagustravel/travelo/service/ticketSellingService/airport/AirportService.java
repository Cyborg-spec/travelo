package pelagustravel.travelo.service.ticketSellingService.airport;

import pelagustravel.travelo.model.ticketSellingService.Airport;

import java.util.Optional;

public interface AirportService {
    Optional<Airport>findById(long id);
}
