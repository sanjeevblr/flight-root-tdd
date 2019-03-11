package com.traveloka.tdd.workshop.flightinventory.repository;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInventoryRepsitory extends JpaRepository<FlightInventory, Integer> {
}
