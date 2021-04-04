package pelagustravel.travelo.exceptions.Product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<Object> productNotFoundExceptionHandler(ProductNotFoundException productNotFoundException){
        ProductException productException=new ProductException();
        productException.setInfo(productNotFoundException.getMessage());
        HttpStatus status=HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(productException,status);
    }
}
