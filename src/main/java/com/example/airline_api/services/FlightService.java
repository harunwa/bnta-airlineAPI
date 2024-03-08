package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Transactional
    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    @Transactional
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    @Transactional
    public Flight getFlightById(Long id){
        return flightRepository.findById(id).get();
    }

    @Transactional
    public void cancelFlight(Long id){
        Flight flight = flightRepository.findById(id).get();
        for (Passenger passenger : flight.getPassengers()) {
            passenger.cancelFlight(flight);
        }
        flightRepository.deleteById(id);
    }

    @Transactional
    public Flight addPassengerToFlight(Long flightId, Long passengerId) {
        Flight foundFlight = flightRepository.findById(flightId).get();
        Passenger passenger1 = passengerRepository.findById(passengerId).get();

        foundFlight.addPassenger(passenger1);
        flightRepository.save(foundFlight);
        return foundFlight;

    }

}
