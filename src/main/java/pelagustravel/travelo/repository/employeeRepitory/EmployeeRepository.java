package pelagustravel.travelo.repository.employeeRepitory;

import org.springframework.data.jpa.repository.JpaRepository;
import pelagustravel.travelo.model.employeeService.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
