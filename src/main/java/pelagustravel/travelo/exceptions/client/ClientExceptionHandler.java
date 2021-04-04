package pelagustravel.travelo.exceptions.client;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClientExceptionHandler {
    @ExceptionHandler(value = {ClientNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> clientNotFoundExceptionHandler(ClientNotFoundException clientNotFoundException){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ClientException clientException= new ClientException();
        clientException.setInfo(clientNotFoundException.getMessage());
        return new ResponseEntity<>(clientException,httpStatus);
    }
    @ExceptionHandler(value = {NotEnoughAmountInCardException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> notEnoughAmountInCardExceptionHandler(NotEnoughAmountInCardException notEnoughAmountInCardException){
        HttpStatus httpStatus=HttpStatus.BAD_REQUEST;
        ClientException clientException= new ClientException();
        clientException.setInfo(notEnoughAmountInCardException.getMessage());
        return new ResponseEntity<>(clientException,httpStatus);
    }
}
