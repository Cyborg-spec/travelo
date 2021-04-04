package pelagustravel.travelo.service.ticketSellingService.client;

import pelagustravel.travelo.model.ticketSellingService.Client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> findById(long id);
    void save(Client client);
    void delete(Client client);
}
