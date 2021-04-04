package pelagustravel.travelo.service.ticketSellingService.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.ticketSellingService.Client;
import pelagustravel.travelo.repository.ticketSellingRepository.ClientRepository;

import java.util.Optional;


@Service
@Transactional
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Optional<Client> findById(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
