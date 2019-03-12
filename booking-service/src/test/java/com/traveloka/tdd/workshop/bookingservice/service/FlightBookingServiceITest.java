package com.traveloka.tdd.workshop.bookingservice.service;

import com.traveloka.tdd.workshop.bookingservice.model.FlightBooking;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightBookingServiceITest {


    MockRestServiceServer mockRestServiceServer;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FlightBookingService flightBookingService;

    @Before
    public void setup(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void shouldSaveOrder(){

        FlightBooking flightBooking = FlightBooking.builder()
                .id(1)
                .bookingDetail(FlightBooking.BookingDetail.builder()
                        .code(1)
                        .fromCity("CGK")
                        .toCity("NYC")
                        .build())
                .quantity(1)
                .userId(1)
                .build();

        mockRestServiceServer.expect(requestTo("http://inventory-service/inventory?id="+flightBooking.getBookingDetail().getCode()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("true", MediaType.APPLICATION_JSON));

        boolean booked = flightBookingService.createFlightBooking(flightBooking);

        mockRestServiceServer.verify();

        Assertions.assertThat(booked).isTrue();

    }
}