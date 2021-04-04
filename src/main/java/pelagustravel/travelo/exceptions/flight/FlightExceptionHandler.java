package pelagustravel.travelo.exceptions.flight;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FlightExceptionHandler {
    @ExceptionHandler(value = {FlightNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> flightNotFoundExceptionHandler(FlightNotFoundException flightNotFoundException ){
        HttpStatus status=HttpStatus.NOT_FOUND;
        FlightException flightException= new FlightException();
        flightException.setInfo(flightNotFoundException.getMessage());
        return new ResponseEntity<>(flightException,status);
    }
}
