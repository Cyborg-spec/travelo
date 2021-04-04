package pelagustravel.travelo.model.ticketSellingService;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pelagustravel.travelo.model.employeeService.Employee;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airport")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Airport {
    @Id
    @Column(name = "airport_id")
    @GeneratedValue(generator = "airport_id_gen")
    @SequenceGenerator(name = "airport_id_gen",sequenceName = "airport_id_seq",allocationSize = 1)
    private long airportId;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airport")
    private Set<Airplane> airplanes;

    @Column(name = "airport_name")
    private String airportName;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airport")
    private Set<Client>clients;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "airport")
    private Set<Employee>employees;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return airportId == airport.airportId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(airportId);
    }
}
