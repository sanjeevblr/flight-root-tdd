package com.traveloka.tdd.workshop.flightinventory.service;

import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.repository.FlightInventoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightInventoryServiceMITest {

    @Autowired
    FlightInventoryService flightInventoryService;

    @Test
    public void shouldSaveAFlightInventory(){
        //Given
        FlightInventory flightInventory = FlightInventory.builder()
                .id(1)
                .fromCity("CGK")
                .toCity("NYC")
                .carrierAirlines("Garuda Airlines")
                .available(true)
                .build();

        //When

        boolean saved = flightInventoryService.save(flightInventory);

        //Then

        Assertions.assertThat(saved).isTrue();


    }


}
