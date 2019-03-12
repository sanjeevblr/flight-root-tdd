package com.traveloka.tdd.workshop.bookingservice.service;

import com.traveloka.tdd.workshop.bookingservice.model.Booking;
import com.traveloka.tdd.workshop.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RestTemplate restTemplate;

    public boolean saveBooking(Booking booking){
        //WHere I will be calling the inventory service

        ResponseEntity<Boolean> forEntity = restTemplate.getForEntity("http://flight-inventory/inventory?id=" + booking.getBookingDetails().getCode(), Boolean.class);

        if(forEntity.getStatusCode().is2xxSuccessful() && forEntity.getBody()){
            Booking saved = bookingRepository.save(booking);
            return saved !=null;
        }else{
            throw new BookingNotCreatedException();
        }


    }

    private class  BookingNotCreatedException extends RuntimeException {
    }
}
