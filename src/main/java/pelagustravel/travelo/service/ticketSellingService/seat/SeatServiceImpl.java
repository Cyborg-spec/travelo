package pelagustravel.travelo.service.ticketSellingService.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pelagustravel.travelo.model.ticketSellingService.Seat;
import pelagustravel.travelo.repository.ticketSellingRepository.SeatRepository;

import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService{
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Optional<Seat> findById(long id) {
        return seatRepository.findById(id);
    }
}
