package pelagustravel.travelo.exceptions.Airplane;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AirplaneExceptionHandler {
    @ExceptionHandler(value = {AirplaneNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> airplaneNotFoundExceptionHandler(AirplaneNotFoundException airplaneNotFoundException){
        AirplaneException airplaneException= new AirplaneException();
        HttpStatus status=HttpStatus.NOT_FOUND;
        airplaneException.setInfo(airplaneNotFoundException.getMessage());
        return new ResponseEntity<>(airplaneException,status);
    }
    @ExceptionHandler(value = {NoAvailableAirplaneException.class})
    public ResponseEntity<Object> noAvailableAirplaneExceptionHandler(NoAvailableAirplaneException noAvailableAirplaneException){
        AirplaneException airplaneException=new AirplaneException();
        HttpStatus status=HttpStatus.NOT_FOUND;
        airplaneException.setInfo(noAvailableAirplaneException.getMessage());
        return new ResponseEntity<>(airplaneException,status);
    }
}
