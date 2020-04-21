package com.sabre.flight.shopping.control.flightdetails;

import com.sabre.flight.shopping.entity.Flight;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FlightDetailsService {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081").build();

    public Flight getFlightDetails(Long flightId) {
        return webClient.get()
                .uri("/flight/{flightId}", flightId)
                .retrieve()
                .bodyToMono(Flight.class)
                .block();
    }
}
