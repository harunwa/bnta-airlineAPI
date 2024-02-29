package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void getAllFlights(){

    }

    public Flight getFlightById(Long id){
        return flightRepository.findById(id).get();
    }

    @Transactional
    public Flight addPassengerToFlight(BookingDTO bookingDTO, Long id){
        Flight flight = flightRepository.findById(id).get();
        Passenger passenger = passengerRepository.findById(bookingDTO.getPassengerId()).get();
        flight.addPassenger(passenger);
        return flight;
    }

    @Transactional
    public void cancelFlight(Long id){
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger : flight.getPassengers()){
            flight.removePassenger(passenger);
        }
        flightRepository.deleteById(id);
    }

}
