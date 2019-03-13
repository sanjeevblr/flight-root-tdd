package com.traveloka.tdd.workshop.e2etest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class FlightInventory {

    Integer id;

    String fromCity;

    String toCity;

    boolean available;

    String carrierAirlines;

}
