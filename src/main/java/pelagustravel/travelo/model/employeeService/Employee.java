package pelagustravel.travelo.model.employeeService;


import lombok.Data;
import pelagustravel.travelo.model.ticketSellingService.Airport;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "employee_id_gen")
    @SequenceGenerator(name = "employee_id_gen",sequenceName = "employee_id_seq",allocationSize = 1)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Enumerated
    @Column(name = "employee_role_id")
    private EmployeeRole employeeRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id")
    private Airport airport;
}
