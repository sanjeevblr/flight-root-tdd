package com.traveloka.tdd.workshop.flightinventory.repository;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightInventoryRepositoryTest {

    @Autowired
            //SUT
    FlightInventoryRepository flightInventoryRepository;

    @Test
    public void shouldSaveFlightInventory(){
        //Given - State and Artefacts

        FlightInventory flightInventory = FlightInventory.builder()
                .id(1)
                .fromCity("CGK")
                .toCity("NYC")
                .carrierAirlines("Garuda Airlines")
                .available(true)
                .build();

        //When - Action
        flightInventoryRepository.save(flightInventory);


        //Then - Verify the behaviour
        Optional<FlightInventory> byId = flightInventoryRepository.findById(1);
        Assertions.assertThat(byId.isPresent()).isTrue();

        Assertions.assertThat(byId.get()).isEqualTo(flightInventory);

    }

}