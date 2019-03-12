package com.traveloka.tdd.workshop.flightinventory.service;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.repository.FlightInventoryRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class FlightInventoryServiceTest {

    FlightInventoryService flightInventoryService = new FlightInventoryService();

    @Test
    public void shouldSaveAFlightInventory(){
        flightInventoryService.flightInventoryRepository = Mockito.mock(FlightInventoryRepository.class);

        FlightInventory flightInventory = FlightInventory.builder()
                .id(1)
                .fromCity("CGK")
                .toCity("NYC")
                .carrierAirlines("Garuda Airlines")
                .available(true)
                .build();

        flightInventoryService.save(flightInventory);

        Mockito.verify(flightInventoryService.flightInventoryRepository).save(Mockito.any(FlightInventory.class));

    }

}