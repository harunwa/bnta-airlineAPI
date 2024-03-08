package com.example.airline_api.services;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

//    public Passenger savePassenger

    @Transactional
    public void addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    @Transactional
    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    @Transactional
    public Passenger getPassengerById(Long id){
        return passengerRepository.findById(id).orElse(null);
    }
}
