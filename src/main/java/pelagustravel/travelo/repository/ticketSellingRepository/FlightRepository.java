package pelagustravel.travelo.repository.ticketSellingRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Country;
import pelagustravel.travelo.model.ticketSellingService.Flight;

import java.util.List;
import java.util.Set;

public interface FlightRepository extends JpaRepository<Flight,Long> {
   Set<Flight> findByAirplane_AirplaneId(long id);
   Set<Flight> findByFromCountryAndToCountry(Country fromCountry, Country toCountry);
}
