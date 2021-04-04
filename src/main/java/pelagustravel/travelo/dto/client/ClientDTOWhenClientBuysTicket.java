package pelagustravel.travelo.dto.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTOWhenClientBuysTicket {
    private long id;
    private long airportId;
    private String firstName;
    private String lastName;
    private String passport;
    private String phone;
    private long amountOnTheCard;
    private Set<Integer> ticketsToBuy;
}
