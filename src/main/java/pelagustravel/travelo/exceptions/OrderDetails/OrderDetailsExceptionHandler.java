package pelagustravel.travelo.exceptions.OrderDetails;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderDetailsExceptionHandler {
    @ExceptionHandler(value = {OrderDetailsNotFoundException.class})
    public ResponseEntity<Object> orderDetailsNotFoundExceptionHandler(OrderDetailsNotFoundException orderDetailsNotFoundException){
        OrderDetailsException orderDetailsException=new OrderDetailsException();
        orderDetailsException.setInfo(orderDetailsNotFoundException.getMessage());
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(orderDetailsException,status);
    }
}
