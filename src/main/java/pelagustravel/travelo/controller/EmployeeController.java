package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.EmployeeDTO;
import pelagustravel.travelo.exceptions.employee.EmployeeNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.employeeService.Employee;
import pelagustravel.travelo.service.employeeService.employee.EmployeeService;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable long id) throws EmployeeNotFoundException {
        Optional<Employee>employee=employeeService.findById(id);
        if(employee.isPresent()){
            return entityToDTOConverter.employeeToEmployeeDTO(employee.get());
        }else {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}
