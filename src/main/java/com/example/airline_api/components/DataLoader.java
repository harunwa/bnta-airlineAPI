package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args){

        Flight flight1 = new Flight("London", 5, "29/02/2024", "9pm");
        flightRepository.save(flight1);

        Passenger p1 = new Passenger("Harun", "harun@gmail.com");
        p1.addPassenger(p1);
        passengerRepository.save(p1);

        Flight flight2 = new Flight("New York", 2, "01/03/2024", "11am");
        flightRepository.save(flight2);

        Passenger p2 = new Passenger("Colin", "Colin@gmail.com");
        p2.addPassenger(p2);
        passengerRepository.save(p2);

        Flight flight3 = new Flight("Miami", 6, "05/03/2024", "4pm");
        flightRepository.save(flight3);

        Passenger p3 = new Passenger("Anna", "anna@gmail.com");
        p3.addPassenger(p3);
        passengerRepository.save(p3);

        Passenger p4 = new Passenger("James", "james@gmail.com");
        p4.addPassenger(p4);
        passengerRepository.save(p4);

        Flight flight4 = new Flight("Spain", 3, "10/03/2024", "1am");
        flightRepository.save(flight4);

    }

}
