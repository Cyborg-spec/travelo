package pelagustravel.travelo.service.employeeService.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pelagustravel.travelo.model.employeeService.Employee;
import pelagustravel.travelo.repository.employeeRepitory.EmployeeRepository;

import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }
}
