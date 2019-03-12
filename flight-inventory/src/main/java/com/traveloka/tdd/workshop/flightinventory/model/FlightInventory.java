package com.traveloka.tdd.workshop.flightinventory.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "flight_inventory", schema = "flight")
public class FlightInventory {

    @Id
            @Column(name = "id")
    Integer id;

    @Column(name = "from_city", nullable = false)
    String fromCity;

    @Column(name = "to_city")

    String toCity;

    @Column(name = "available")
    boolean available;

    @Column(name = "carrier_airlines")
    String carrierAirlines;
}
