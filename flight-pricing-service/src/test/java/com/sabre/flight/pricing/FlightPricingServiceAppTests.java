package com.sabre.flight.pricing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.sabre.flight.pricing.entity.Flight;
import com.sabre.flight.pricing.entity.Money;
import org.apache.http.HttpStatus;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightPricingServiceAppTests {

    @LocalServerPort
    protected int serverPort;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnAnyPriceIfAsked() throws IOException {
        Flight flight = new Flight(1000L, LocalDateTime.now().plusDays(5), "KRK", "WWA");

        ExtractableResponse<Response> response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(flight))
                .port(serverPort)
                .post("/getFlightPrice")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();
        String responseBody = response.body().asString();
        Money flightPrice = objectMapper.readValue(responseBody, Money.class);
        assertNotNull(flightPrice);
    }

    @Test
    @Ignore
    public void shouldRespondFastAsHell() throws IOException {
        Flight flight = new Flight(1000L, LocalDateTime.now().plusDays(5), "KRK", "WWA");

        ExtractableResponse<Response> response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(objectMapper.writeValueAsString(flight))
                .port(serverPort)
                .post("/getFlightOffer")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();

        assertTrue(response.time() < 500);
    }

}
