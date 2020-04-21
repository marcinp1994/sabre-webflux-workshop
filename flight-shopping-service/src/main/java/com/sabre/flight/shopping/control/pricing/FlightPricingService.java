package com.sabre.flight.shopping.control.pricing;

import com.sabre.flight.shopping.entity.Flight;
import com.sabre.flight.shopping.entity.Money;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class FlightPricingService {
    private WebClient webClient = WebClient.create("http://localhost:8082");

    public Money getFlightPrice(Flight flight) {
        return webClient.post()
                .uri("/getFlightPrice")
                .body(BodyInserters.fromObject(flight))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToMono(Money.class)
                .block();
    }
}
