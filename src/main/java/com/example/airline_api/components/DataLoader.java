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
    public void run(ApplicationArguments args) throws Exception {

        // LONDON
        Flight londonFlight = new Flight("London", 5, "29/02/2024", "9pm");
        flightRepository.save(londonFlight);

        Passenger harun = new Passenger("Harun", "harun@gmail.com");
        harun.addFlight(londonFlight);
        passengerRepository.save(harun);

        // NEW YORK
        Flight newYorkFlight = new Flight("New York", 2, "01/03/2024", "11am");
        flightRepository.save(newYorkFlight);

        Passenger colin = new Passenger("Colin", "Colin@gmail.com");
        colin.addFlight(newYorkFlight);
        passengerRepository.save(colin);

        // MIAMI
        Flight miamiFlight = new Flight("Miami", 6, "05/03/2024", "4pm");
        flightRepository.save(miamiFlight);

        Passenger anna = new Passenger("Anna", "anna@gmail.com");
        anna.addFlight(miamiFlight);
        passengerRepository.save(anna);

        Passenger james = new Passenger("James", "james@gmail.com");
        james.addFlight(miamiFlight);
        passengerRepository.save(james);

        // SPAIN
        Flight spainFlight = new Flight("Spain", 3, "10/03/2024", "1am");
        flightRepository.save(spainFlight);
    }
}
