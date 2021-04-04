package pelagustravel.travelo.repository.ticketSellingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.ticketSellingService.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
    Country findByCountryName(String countryName);
}
