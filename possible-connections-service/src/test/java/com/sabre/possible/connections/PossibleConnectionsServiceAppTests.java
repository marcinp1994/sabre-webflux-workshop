package com.sabre.possible.connections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ExtractableResponse;
import com.jayway.restassured.response.Response;
import com.sabre.possible.connections.entity.Connection;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PossibleConnectionsServiceAppTests {

    @LocalServerPort
    protected int serverPort;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldReturnSomeConnections() throws Exception {
        ExtractableResponse<Response> response = RestAssured.given()
                .port(serverPort)
                .get("/findPossibleConnections")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();
        String responseBody = response.body().asString();
        Connection[] flightOffer = objectMapper.readValue(responseBody, Connection[].class);
        assertTrue(flightOffer.length > 0);
    }

}
