package com.traveloka.tdd.workshop.flightinventory.mode;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "flight_carrier")
    String flightCarrier;

    //@Column(name = "travel_date")
    //Date travelDate;

    @Column(name = "availability")
    boolean availability;
}
