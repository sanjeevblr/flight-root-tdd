package com.traveloka.tdd.workshop.flightinventory.transformer;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightInventoryTransformerTest {

    //SUT
    FlightInventoryTransformer flightInventoryTransformer = new FlightInventoryTransformer();

    @Test
    public void shouldTransformThisFlightInventory() {
        FlightInventoryDTO flightInventoryDTO = FlightInventoryDTO.builder()
                .id(1)
                .availability(true)
                .flightCarrier("Garuda Airways")
                .fromCity("CGK")
                .toCity("BLR")
                .build();

        FlightInventory expectedFlightInventory = FlightInventory.builder()
                .id(1)
                .flightCarrier(flightInventoryDTO.getFlightCarrier())
                .fromCity(flightInventoryDTO.getFromCity())
                .toCity(flightInventoryDTO.getToCity())
                .availability(flightInventoryDTO.isAvailability())
                .build();

        FlightInventory actualInventory = flightInventoryTransformer.transform(flightInventoryDTO);

        Assertions.assertThat(actualInventory).isEqualTo(expectedFlightInventory);
    }

}