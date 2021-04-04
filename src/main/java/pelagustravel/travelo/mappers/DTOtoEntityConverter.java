package pelagustravel.travelo.mappers;

import org.springframework.stereotype.Component;
import pelagustravel.travelo.dto.client.ClientDTOWhenClientBuysTicket;
import pelagustravel.travelo.model.ticketSellingService.Client;

@Component
public class DTOtoEntityConverter {
  public Client clientDtoToClientEntity(ClientDTOWhenClientBuysTicket clientDTOWhenClientBuysTicket){
      return Client.builder()
              .clientId(clientDTOWhenClientBuysTicket.getId())
              .firstName(clientDTOWhenClientBuysTicket.getFirstName())
              .lastName(clientDTOWhenClientBuysTicket.getLastName())
              .phone(clientDTOWhenClientBuysTicket.getPhone())
              .passport(clientDTOWhenClientBuysTicket.getPassport()).build();
  }
}
