package com.traveloka.tdd.workshop.flightinventory.mode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInventoryDTO {

    int id;

    String fromCity;

    String toCity;

    boolean availability;

            String flightCarrier;

    public boolean isValid() {
        return id > 0 && fromCity != null && toCity != null && flightCarrier != null;
    }
}
