package pelagustravel.travelo.service.ticketSellingService.seat;

import pelagustravel.travelo.model.ticketSellingService.Seat;

import java.util.Optional;

public interface SeatService {
    Optional<Seat> findById(long id);
}
