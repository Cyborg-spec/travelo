package pelagustravel.travelo.mappers;

import org.springframework.stereotype.Component;
import pelagustravel.travelo.dto.RoleDTO;
import pelagustravel.travelo.dto.EmployeeDTO;
import pelagustravel.travelo.dto.ProductDTO;
import pelagustravel.travelo.dto.AirplaneDTO;
import pelagustravel.travelo.dto.AirportDTO;
import pelagustravel.travelo.dto.client.ClientDTO;
import pelagustravel.travelo.dto.CountryDTO;
import pelagustravel.travelo.dto.FlightDTO;
import pelagustravel.travelo.dto.OrderDTO;
import pelagustravel.travelo.dto.orderDetails.OrderDetailsDTO;
import pelagustravel.travelo.dto.PostOfficeDTO;
import pelagustravel.travelo.dto.SeatDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.model.employeeService.Employee;
import pelagustravel.travelo.model.employeeService.EmployeeRole;
import pelagustravel.travelo.model.productDeliveryService.Order;
import pelagustravel.travelo.model.productDeliveryService.OrderDetails;
import pelagustravel.travelo.model.productDeliveryService.PostOffice;
import pelagustravel.travelo.model.productDeliveryService.Product;
import pelagustravel.travelo.model.ticketSellingService.*;

import java.util.HashSet;
import java.util.Set;

@Component
public class EntityToDTOConverter {
    public AirplaneDTO airplaneToAirplaneDTO(Airplane airplane){
        return AirplaneDTO.builder()
                .name(airplane.getAirplaneName())
                .build();
    }

    public Set<AirplaneDTO> airplaneToAirplaneDTO(Set<Airplane>airplanes){
        Set<AirplaneDTO>result=new HashSet<>();
        for(Airplane airplane:airplanes){
            result.add(airplaneToAirplaneDTO(airplane));
        }
        return result;
    }

    public AirportDTO airportToAirportDTO(Airport airport){
        return AirportDTO.builder()
                .clients(clientToClientDTO(airport.getClients()))
                .airplanes(airplaneToAirplaneDTO(airport.getAirplanes()))
                .employees(employeeToEmployeeDTO(airport.getEmployees()))
                .build();
    }
    public ClientDTO clientToClientDTO(Client client){
        return ClientDTO.builder()
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .passport(client.getPassport())
                .phone(client.getPhone())
                .build();
    }

    public Set<ClientDTO> clientToClientDTO(Set<Client> clients){
        Set<ClientDTO>result=new HashSet<>();
        for(Client client:clients){
            result.add(clientToClientDTO(client));
        }
        return result;
    }

    public CountryDTO countryToCountryDTO(Country country){
        return CountryDTO.builder()
                .countryName(country.getCountryName())
                .build();
    }
    public FlightDTO flightToFlightDTO(Flight flight){
        return FlightDTO.builder()
                .boardingTime(flight.getBoardingTime())
                .departingTime(flight.getDepartingTime())
                .fromCountry(flight.getFromCountry().getCountryName())
                .toCountry(flight.getToCountry().getCountryName())
                .build();
    }

    public Set<FlightDTO> flightToFLightDTO(Set<Flight>flights){
        Set<FlightDTO>result=new HashSet<>();
        for(Flight flight:flights){
            result.add(flightToFlightDTO(flight));
        }
        return result;
    }

    public OrderDTO orderToOrderDTO(Order order){
      return OrderDTO.builder()
                .id(order.getId())
                .postOffice(postOfficeToPostOfficeDTO(order.getPostOffice()))
                .orderDate(order.getOrderDate())
                .isDelivered(order.isDelivered())
                .build();
    }

    public Set<OrderDTO> orderToOrderDTO(Set<Order>orders){
        Set<OrderDTO>result= new HashSet<>();
        for(Order order:orders){
            result.add(orderToOrderDTO(order));
        }
        return result;
    }

    public OrderDetailsDTO orderDetailsToOrderDetailsDTO(OrderDetails orderDetails){
        return OrderDetailsDTO.builder()
                .order(orderToOrderDTO(orderDetails.getOrder()))
                .product(productToProductDTO(orderDetails.getProduct()))
                .quantity(orderDetails.getQuantity())
                .price(orderDetails.getPrice())
                .fromCountry(countryToCountryDTO(orderDetails.getFromCountry()))
                .toCountry(countryToCountryDTO(orderDetails.getToCountry()))
                .build();
    }

    public Set<OrderDetailsDTO> orderDetailsToOrderDetailsDTO(Set<OrderDetails>orderDetails){
        Set<OrderDetailsDTO>result=new HashSet<>();
        for(OrderDetails orderDetail:orderDetails){
            result.add(orderDetailsToOrderDetailsDTO(orderDetail));
        }
        return result;
    }

    public PostOfficeDTO postOfficeToPostOfficeDTO(PostOffice postOffice){
        return PostOfficeDTO.builder()
                .name(postOffice.getPostOfficeName())
                .build();
    }
    public ProductDTO productToProductDTO(Product product){
        return ProductDTO.builder()
                .weight(product.getWeight())
                .build();
    }

    public Set<ProductDTO> productToProductDTO(Set<Product>products){
        Set<ProductDTO>result=new HashSet<>();
        for(Product product:products){
            result.add(productToProductDTO(product));
        }
        return result;
    }

    public SeatDTO seatToSeatDTO(Seat seat){
        return SeatDTO.builder()
                .id(seat.getSeatId())
                .seatClass(seat.getSeatClass())
                .build();
    }

    public Set<SeatDTO> seatToSeatDTO(Set<Seat>seats){
        Set<SeatDTO>result=new HashSet<>();
        for(Seat seat:seats){
            result.add(seatToSeatDTO(seat));
        }
        return result;
    }

    public TicketDTO ticketToTicketDTO(Ticket ticket){
        return TicketDTO.builder()
                .airplane(airplaneToAirplaneDTO(ticket.getFlight().getAirplane()))
                .flight(flightToFlightDTO(ticket.getFlight()))
                .ticketPrice(ticket.getTicketPrice())
                .seat(seatToSeatDTO(ticket.getSeat()))
                .build();
    }

    public Set<TicketDTO> ticketToTicketDTO(Set<Ticket> tickets){
        Set<TicketDTO>result=new HashSet<>();
        for(Ticket ticket:tickets){
            result.add(ticketToTicketDTO(ticket));
        }
        return result;
    }

    public Set<Set<TicketDTO>> ticketsListsToTicketDTO(Set<Set<Ticket>> ticketLists){
        Set<Set<TicketDTO>>result=new HashSet<>();
        for(Set<Ticket>ticketList:ticketLists){
            result.add(ticketToTicketDTO(ticketList));
        }
        return result;
    }

    public EmployeeDTO employeeToEmployeeDTO(Employee employee){
        return EmployeeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .phone(employee.getPhone())
                .role(roleToRoleDTO(employee.getEmployeeRole()))
                .airportName(employee.getAirport().getAirportName()).build();
    }

    public Set<EmployeeDTO> employeeToEmployeeDTO(Set<Employee>employees){
        Set<EmployeeDTO>result=new HashSet<>();
        for(Employee employee:employees){
            result.add(employeeToEmployeeDTO(employee));
        }
        return result;
    }

    public RoleDTO roleToRoleDTO(EmployeeRole role){
        return RoleDTO.builder()
                .role(role.name()).build();
    }

}
