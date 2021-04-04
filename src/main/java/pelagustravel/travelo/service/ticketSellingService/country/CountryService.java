package pelagustravel.travelo.service.ticketSellingService.country;

import pelagustravel.travelo.model.ticketSellingService.Country;

public interface CountryService {
    Country findByCountryName(String countryName);
}
