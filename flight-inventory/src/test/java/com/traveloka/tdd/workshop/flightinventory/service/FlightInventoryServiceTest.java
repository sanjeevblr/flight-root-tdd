package com.traveloka.tdd.workshop.flightinventory.service;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightInventoryServiceTest {

    @Autowired
    FlightInventoryService flightInventoryService;

    @Test
    public void shouldSaveAFlightInventory() {
        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(1)
                .fromCity("CGK")
                .toCity("NY")
                .availability(true)
                .flightCarrier("Garuda Airlines")
                .build();

        boolean saved = flightInventoryService.save(flightInventoryDTO);
        Assertions.assertThat(saved).isEqualTo(true);
    }

    @Test
    public void shouldNotSaveAFlightInventory() {
        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(1)
                .toCity("NY")
                .availability(true)
                .flightCarrier("Garuda Airlines")
                .build();

        boolean saved = flightInventoryService.save(flightInventoryDTO);
        Assertions.assertThat(saved).isEqualTo(false);
    }


}
