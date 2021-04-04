package pelagustravel.travelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
  private String fromCountry;
  private String toCountry;
  private LocalTime boardingTime;
  private LocalTime departingTime;
}
