package com.traveloka.tdd.workshop.flightinventory.repository;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventory;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.Instant;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightInventoryRepsitoryTest {

    @Autowired
    FlightInventoryRepsitory flightInventoryRepsitory;

    @Test
    public void testBootUp() {
        Assertions.assertThat(flightInventoryRepsitory).isNotNull();
    }

    @Test
    public void shouldSaveAFlightInventory() {
        FlightInventory flightInventory = FlightInventory.builder()
                .id(1)
                .fromCity("BLR")
                .toCity("CGK")
                .flightCarrier("Indonesian Airlines")
                .availability(true)
                //.travelDate(Date.from(Instant.now()))
                .build();

        flightInventoryRepsitory.save(flightInventory);

        Assertions.assertThat(flightInventoryRepsitory.findById(1).get()).isEqualTo(flightInventory);
    }
}