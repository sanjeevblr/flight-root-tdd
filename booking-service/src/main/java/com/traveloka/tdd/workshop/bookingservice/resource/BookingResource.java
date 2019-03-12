package com.traveloka.tdd.workshop.bookingservice.resource;

import com.traveloka.tdd.workshop.bookingservice.model.Booking;
import com.traveloka.tdd.workshop.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingResource {

    @Autowired
    BookingService bookingService;

    @PostMapping
    ResponseEntity createBooking(@RequestBody Booking booking){
        boolean saved = bookingService.saveBooking(booking);
        return ResponseEntity.ok(saved);
    }
}
