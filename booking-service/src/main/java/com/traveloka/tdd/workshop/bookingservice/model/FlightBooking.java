package com.traveloka.tdd.workshop.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "flight_booking", schema = "flight")
public class FlightBooking {

    @Id
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Embedded
    BookingDetail bookingDetail;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BookingDetail {

        @Column(name = "code")
        Integer code;

        @Column(name = "fromCity")
        String fromCity;

        @Column(name = "to_city")
        String toCity;

    }

    @Column(name = "quantity")
    Integer quantity;
}
