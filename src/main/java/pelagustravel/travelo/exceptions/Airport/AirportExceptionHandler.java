package pelagustravel.travelo.exceptions.Airport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AirportExceptionHandler {
    @ExceptionHandler(value = {AirportNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> airportNotFoundExceptionHandler(AirportNotFoundException airportNotFoundException){
        AirportException airportException= new AirportException();
        airportException.setInfo(airportNotFoundException.getMessage());
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(airportException,status);
    }
}
