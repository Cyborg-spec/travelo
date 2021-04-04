package pelagustravel.travelo.service.ticketSellingService.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.ticketSellingService.Country;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.repository.ticketSellingRepository.FlightRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
    @Autowired
    FlightRepository flightRepository;

    @Override
    public Optional<Flight> findById(long id) {
        return flightRepository.findById(id);
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public Set<Flight> findByAirplaneId(long id) {
        return flightRepository.findByAirplane_AirplaneId(id);
    }

    @Override
    public Set<Flight> findByFromCountryAndToCountry(Country fromCountry, Country toCountry) {
        return flightRepository.findByFromCountryAndToCountry(fromCountry,toCountry);
    }
}
