package com.traveloka.tdd.workshop.flightinventory.service;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.repository.FlightInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightInventoryService {

    @Autowired
    FlightInventoryRepository flightInventoryRepository;

    public boolean save(FlightInventory flightInventory) {
        FlightInventory saved = flightInventoryRepository.save(flightInventory);
        return saved !=null;
    }

    public FlightInventory find(Integer id) {
        return flightInventoryRepository.findById(id).get();
    }
}
