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
@Table(name = "booking", schema = "flight")
public class Booking {

    @Column(name = "id")
            @Id
    Integer id;

    @Column(name = "user_id")
    Integer userId;

    @Embedded
    BookingDetails bookingDetails;

    @Embeddable
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BookingDetails {

        @Column(name = "code")
        Integer code;

        @Column(name = "from_city")
        String fromCity;

        @Column(name = "to_city")
        String toCity;
    }

    @Column(name = "number_of_ticket")
    Integer numberOfTicket;
}
