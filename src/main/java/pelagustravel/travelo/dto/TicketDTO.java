package pelagustravel.travelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    private FlightDTO flight;

    private AirplaneDTO airplane;

    private SeatDTO seat;

    private long ticketPrice;
}
