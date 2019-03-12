package com.traveloka.tdd.workshop.bookingservice.repository;

import com.traveloka.tdd.workshop.bookingservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
