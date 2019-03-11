package com.traveloka.tdd.workshop.flightinventory.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class FlightInventoryResourceTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldStart() {
        Assertions.assertThat(mockMvc).isNotNull();
    }

    @Test
    public void shouldSaveAFlightInventory() throws Exception {


        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(1)
                .toCity("BLR")
                .fromCity("CGK")
                .flightCarrier("Garuda Airways")
                .availability(true)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(flightInventoryDTO);

        mockMvc.perform(
                post("/inventory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(valueAsString)
        ).andDo(print())
                .andExpect(status().isCreated());


    }

    @Test
    public void shouldgetAFlightInventory() throws Exception {


        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(1)
                .toCity("BLR")
                .fromCity("CGK")
                .flightCarrier("Garuda Airways")
                .availability(true)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsStringDTO = objectMapper.writeValueAsString(flightInventoryDTO);

        mockMvc.perform(
                post("/inventory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(valueAsStringDTO)
        ).andDo(print())
                .andExpect(status().isCreated());

        /*mockMvc.perform(
                get("/inventory")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )   .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(valueAsStringDTO));*/


    }
}
