package pelagustravel.travelo.service.employeeService.employee;

import pelagustravel.travelo.model.employeeService.Employee;

import java.util.Optional;

public interface EmployeeService {
    Optional<Employee>findById(long id);
}
