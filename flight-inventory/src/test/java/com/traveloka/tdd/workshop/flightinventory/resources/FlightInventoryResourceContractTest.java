package com.traveloka.tdd.workshop.flightinventory.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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


    @Test
    public void shouldAdhereToThisContract() throws Exception {

        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(-100)
                .toCity("BLR")
                .fromCity("CGK")
                .flightCarrier("Garuda Airways")
                .availability(true)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(flightInventoryDTO);

        mockMvc.perform(
                post("/inventory")
                        .content(valueAsString)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(valueAsString));


    }
}
