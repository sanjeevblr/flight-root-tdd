package com.traveloka.tdd.workshop.e2etest;

import com.traveloka.tdd.workshop.e2etest.model.FlightBooking;
import com.traveloka.tdd.workshop.e2etest.model.FlightInventory;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)

public class E2EFlightTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void setup(){


        FlightInventory flightInventory = FlightInventory.builder()
                .id(3)
                .availability(true)
                .flightCarrier("SGP Airlines")
                .fromCity("CGK")
                .toCity("SGP")
                .build();

        ResponseEntity<Boolean> inventoryCreated = restTemplate.postForEntity("http://localhost:8000/flight-inventory/inventory", flightInventory, Boolean.class);

        Assertions.assertThat(inventoryCreated.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        FlightBooking flightBooking = FlightBooking.builder()
                .id(1)
                .userId(2)
                .fromCity("CGK")
                .build();

    }
}
