package com.traveloka.tdd.workshop.bookingservice.service;

import com.traveloka.tdd.workshop.bookingservice.model.FlightBooking;
import com.traveloka.tdd.workshop.bookingservice.repository.FlightBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightBookingService {

    @Autowired
    FlightBookingRepository flightBookingRepository;

    @Autowired
    RestTemplate restTemplate;

    public boolean createFlightBooking(FlightBooking flightBooking) {

        ResponseEntity<Boolean> forEntity = restTemplate.getForEntity("http://localhost:8081/inventory?id=" + flightBooking.getBookingDetail().getCode(), Boolean.class);

        if(forEntity.getStatusCode() == HttpStatus.OK){
            FlightBooking saved = flightBookingRepository.save(flightBooking);
            return saved != null;
        }else{
            throw new BookingNotCreatedException();
        }




    }

    public boolean isBookingCreated(Integer id) {
        return flightBookingRepository.findById(id).isPresent();
    }

    private class BookingNotCreatedException extends RuntimeException {
    }
}
