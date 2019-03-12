package com.traveloka.tdd.workshop.bookingservice.service;

import com.traveloka.tdd.workshop.bookingservice.model.Booking;
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
public class BookingServiceTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    BookingService bookingService;

    MockRestServiceServer mockRestServiceServer;

    @Before
    public void setup(){
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }


    @Test
    public void shouldSaveOrder(){

        Booking booking = Booking.builder()
                .id(1)
                .bookingDetails(Booking.BookingDetails.builder()
                        .code(2)
                        .fromCity("CGK")
                        .toCity("NYC")
                        .build())
                .numberOfTicket(5)
                .userId(3)
                .build();

        mockRestServiceServer.expect(requestTo("http://localhost:8081/inventory?id="+booking.getBookingDetails().getCode()))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("true", MediaType.APPLICATION_JSON));

        //When
        boolean saved = bookingService.saveBooking(booking);

        Assertions.assertThat(saved).isTrue();

        mockRestServiceServer.verify();

    }
}