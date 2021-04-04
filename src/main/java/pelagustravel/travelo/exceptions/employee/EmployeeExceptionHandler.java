package pelagustravel.travelo.exceptions.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(value = {EmployeeNotFoundException.class})
    public ResponseEntity<Object> employeeNotFoundExceptionHandler(EmployeeNotFoundException employeeNotFoundException){
        EmployeeException employeeException=new EmployeeException();
        employeeException.setInfo(employeeNotFoundException.getMessage());
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(employeeException,httpStatus);
    }
}
