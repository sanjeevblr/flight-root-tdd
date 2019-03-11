package com.traveloka.tdd.workshop.bookingservice.repository;

import com.traveloka.tdd.workshop.bookingservice.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
