package com.traveloka.tdd.workshop.e2etest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightBooking {

    Integer id;

    Integer userId;

    Integer code;

    String fromCity;

    String toCity;

    Integer quantity;
}
