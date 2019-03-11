package com.traveloka.tdd.workshop.bookingservice.service;

import com.traveloka.tdd.workshop.bookingservice.model.FlightBooking;
import com.traveloka.tdd.workshop.bookingservice.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightBookingService {

    @Autowired
    FlightBookingRepository flightBookingRepository;

    public boolean createFlightBooking(FlightBooking flightBooking) {

        FlightBooking saved = flightBookingRepository.save(flightBooking);
        return saved != null;


    }
}
