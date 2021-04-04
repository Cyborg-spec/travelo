package pelagustravel.travelo.service.ticketSellingService.flight;

import pelagustravel.travelo.model.ticketSellingService.Country;
import pelagustravel.travelo.model.ticketSellingService.Flight;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FlightService {
    Optional<Flight> findById(long id);
    void deleteFlight(Flight flight);
    Set<Flight> findByAirplaneId(long id);
    Set<Flight> findByFromCountryAndToCountry(Country fromCountry, Country toCountry);
}
