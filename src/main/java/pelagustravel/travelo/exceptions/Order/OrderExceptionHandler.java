package pelagustravel.travelo.exceptions.Order;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(value = {OrderNotFoundException.class})
    public ResponseEntity<Object> orderNotFoundExceptionHandler(OrderNotFoundException orderNotFoundException){
        OrderException orderException=new OrderException();
        orderException.setInfo(orderNotFoundException.getMessage());
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(orderException,status);
    }
}
