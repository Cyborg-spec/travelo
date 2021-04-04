package pelagustravel.travelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pelagustravel.travelo.dto.AirplaneDTO;
import pelagustravel.travelo.dto.client.ClientDTO;
import pelagustravel.travelo.dto.TicketDTO;
import pelagustravel.travelo.exceptions.Airport.AirportNotFoundException;
import pelagustravel.travelo.mappers.EntityToDTOConverter;
import pelagustravel.travelo.model.ticketSellingService.Airplane;
import pelagustravel.travelo.model.ticketSellingService.Airport;
import pelagustravel.travelo.model.ticketSellingService.Flight;
import pelagustravel.travelo.model.ticketSellingService.Ticket;
import pelagustravel.travelo.service.ticketSellingService.airport.AirportService;

import java.util.*;

@RestController
public class AirportController {
    @Autowired
    AirportService airportService;

    @Autowired
    EntityToDTOConverter entityToDTOConverter;

    @GetMapping("/airport/{id}/airplanes")
    public Set<AirplaneDTO> airportAirplanes(@PathVariable long id) throws AirportNotFoundException {
        Optional<Airport> airport = airportService.findById(id);
        if (airport.isPresent()) {
            return entityToDTOConverter.airplaneToAirplaneDTO(airport.get().getAirplanes());
        }else {
            throw new AirportNotFoundException("Airport with this id not found in database");
        }
    }

    @GetMapping("/airport/{id}/tickets")
    public Set<Set<TicketDTO>> airportTickets(@PathVariable long id) throws AirportNotFoundException {
       Optional<Airport>airport=airportService.findById(id);
       if(airport.isPresent()) {
           Set<Airplane>airplanes=airport.get().getAirplanes();
           Set<Set<Flight>>flights=new HashSet<>();
           Set<Set<Ticket>>tickets=new HashSet<>();
           for(Airplane airplane:airplanes){
               flights.add(airplane.getFlights());
           }
           for(Set<Flight>flightList:flights){
               for(Flight flight:flightList){
                   tickets.add(flight.getTickets());
               }
           }
           return entityToDTOConverter.ticketsListsToTicketDTO(tickets);
       }else {
           throw new AirportNotFoundException("Airport with this id not found in database");
       }
    }

    @GetMapping("/airport/{id}/clients")
    public Set<ClientDTO> airportClients(@PathVariable long id) throws AirportNotFoundException {
        Optional<Airport>airport=airportService.findById(id);
        if(airport.isPresent()){
            return entityToDTOConverter.clientToClientDTO(airport.get().getClients());
        }else {
            throw new AirportNotFoundException("Airport with this id not found in database");
        }
    }
}
