package com.sabre.flight.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.sabre.flight.shopping.control.FlightDetailsRepository;
import com.sabre.flight.shopping.entity.Flight;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightDetailsServiceAppTests {

    @LocalServerPort
    protected int serverPort;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FlightDetailsRepository flightDetailsRepository;

    @Test
    public void shouldReturnPredefinedFlights() throws IOException {
        ExtractableResponse<Response> response = RestAssured.given()
                .port(serverPort)
                .get("/flight/1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();
        String responseBody = response.body().asString();
        Flight flight = objectMapper.readValue(responseBody, Flight.class);
        assertEquals(flightDetailsRepository.getFlightDetails(1L), flight);
    }

}
