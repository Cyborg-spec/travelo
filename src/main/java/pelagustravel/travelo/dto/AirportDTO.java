package pelagustravel.travelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pelagustravel.travelo.dto.client.ClientDTO;

import java.util.Set;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AirportDTO {
    private Set<ClientDTO> clients;
    private Set<AirplaneDTO>airplanes;
    private Set<EmployeeDTO>employees;
}
