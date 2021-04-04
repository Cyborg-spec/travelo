package pelagustravel.travelo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private RoleDTO role;
    private String airportName;
}
