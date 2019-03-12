package com.traveloka.tdd.workshop.flightinventory.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlightInventoryTest {

    FlightInventory flightInventory;

    @Test
    public void testLombok(){
        flightInventory = FlightInventory.builder()
                .id(1)
                .available(true)
                .carrierAirlines("Garuda Airlines")
                .fromCity("CGK")
                .toCity("NYC")
                .build();

        FlightInventory grauda = new FlightInventory(1, "from.city", "to.city", true, "Grauda");
    }
}