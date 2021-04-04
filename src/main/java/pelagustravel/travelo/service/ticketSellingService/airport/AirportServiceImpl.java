package pelagustravel.travelo.service.ticketSellingService.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pelagustravel.travelo.model.ticketSellingService.Airport;
import pelagustravel.travelo.repository.ticketSellingRepository.AirportRepository;

import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService{
    @Autowired
    AirportRepository airportRepository;

    @Override
    public Optional<Airport> findById(long id) {
        return airportRepository.findById(id);
    }
}
