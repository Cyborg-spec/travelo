package pelagustravel.travelo.exceptions.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import pelagustravel.travelo.model.ticketSellingService.Ticket;


@RestControllerAdvice
public class TicketExceptionHandler {
    @ExceptionHandler(value = {TicketNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> ticketNotFoundExceptionHandler(TicketNotFoundException ticketNotFoundException){
        TicketException ticketException=new TicketException();
        ticketException.setInfo(ticketNotFoundException.getMessage());
        HttpStatus status= HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ticketException,status);
    }
    @ExceptionHandler(value = {TicketAlreadyBoughtException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> ticketAlreadyBoughtExceptionHandler(TicketAlreadyBoughtException ticketAlreadyBoughtException){
        TicketException ticketException=new TicketException();
        ticketException.setInfo(ticketAlreadyBoughtException.getMessage());
        HttpStatus status=HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(ticketException,status);
    }
    @ExceptionHandler(value = {AllSelectedTicketsBoughtException.class})
    public ResponseEntity<Object> allSelectedTicketBoughtExceptionHandler(AllSelectedTicketsBoughtException allSelectedTicketsBoughtException){
        TicketException ticketException=new TicketException();
        ticketException.setInfo(allSelectedTicketsBoughtException.getMessage());
        HttpStatus status=HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(ticketException,status);
    }
}
