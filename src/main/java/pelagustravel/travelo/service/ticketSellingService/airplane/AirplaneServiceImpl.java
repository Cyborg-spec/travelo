package pelagustravel.travelo.service.ticketSellingService.airplane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.ticketSellingService.Airplane;
import pelagustravel.travelo.repository.ticketSellingRepository.AirplaneRepository;

import java.util.Optional;

@Service
@Transactional
public class AirplaneServiceImpl implements AirplaneService{
    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public Optional<Airplane> findById(long id) {
        return airplaneRepository.findById(id);
    }
}
