package com.traveloka.tdd.workshop.flightinventory.transformer;

import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventory;
import com.traveloka.tdd.workshop.flightinventory.mode.FlightInventoryDTO;
import org.springframework.stereotype.Component;

@Component
public class FlightInventoryTransformer {
    public FlightInventory transform(FlightInventoryDTO flightInventoryDTO) {
        return FlightInventory.builder()
                .id(flightInventoryDTO.getId())
                .fromCity(flightInventoryDTO.getFromCity())
                .toCity(flightInventoryDTO.getToCity())
                .availability(flightInventoryDTO.isAvailability())
                .flightCarrier(flightInventoryDTO.getFlightCarrier())
                .build();
    }
}
