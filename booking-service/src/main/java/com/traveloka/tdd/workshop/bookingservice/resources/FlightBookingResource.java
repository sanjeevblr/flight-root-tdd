package com.traveloka.tdd.workshop.bookingservice.resources;

import com.traveloka.tdd.workshop.bookingservice.model.FlightBooking;
import com.traveloka.tdd.workshop.bookingservice.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/booking")
public class FlightBookingResource {

    @Autowired
    FlightBookingService flightBookingService;

    @PostMapping
    public ResponseEntity createABooking(@RequestBody FlightBooking flightBooking) {
        boolean flightBooking1 = flightBookingService.createFlightBooking(flightBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightBooking1);
    }

}

