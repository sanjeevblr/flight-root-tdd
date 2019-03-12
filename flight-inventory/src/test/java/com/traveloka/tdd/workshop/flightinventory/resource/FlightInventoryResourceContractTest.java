package com.traveloka.tdd.workshop.flightinventory.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.tdd.workshop.flightinventory.model.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.repository.FlightInventoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class FlightInventoryResourceContractTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    FlightInventoryRepository flightInventoryRepository;

    @Test
    public void shouldSaveFlightInventory() throws Exception {

        FlightInventory flightInventory = FlightInventory.builder()
                .id(-100)
                .fromCity("CGK")
                .toCity("NYC")
                .carrierAirlines("Garuda Airlines")
                .available(true)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(flightInventory);

        mockMvc.perform(post("/inventory")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(writeValueAsString))
                .andExpect(status().isOk())
                .andExpect(content().string("parsed"))
                .andDo(print());



    }
}
