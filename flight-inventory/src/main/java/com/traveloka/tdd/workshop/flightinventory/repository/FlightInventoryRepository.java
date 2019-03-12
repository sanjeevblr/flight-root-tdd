package com.traveloka.tdd.workshop.flightinventory.repository;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInventoryRepository extends JpaRepository<FlightInventory, Integer> {
}
