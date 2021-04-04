package pelagustravel.travelo.service.ticketSellingService.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.ticketSellingService.Country;
import pelagustravel.travelo.repository.ticketSellingRepository.CountryRepository;

@Service
@Transactional
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country findByCountryName(String countryName) {
        return countryRepository.findByCountryName(countryName);
    }
}
