package com.traveloka.tdd.workshop.e2etest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.web.client.RestTemplateExchangeTags;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookingE2ETest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void shouldBookAFlight(){
        FlightInventory flightInventory = FlightInventory.builder()
                .id(1)
                .available(true)
                .carrierAirlines("Garuda")
                .fromCity("CGK")
                .toCity("NYC")
                .build();

        ResponseEntity<Boolean> booleanResponseEntity = restTemplate.postForEntity("http://localhost:8000/inventory-service/inventory", flightInventory, Boolean.class);

        Assertions.assertThat(booleanResponseEntity.getBody()).isTrue();
    }
}
