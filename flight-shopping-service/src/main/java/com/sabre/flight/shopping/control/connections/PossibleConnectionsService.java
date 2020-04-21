package com.sabre.flight.shopping.control.connections;

import com.sabre.flight.shopping.entity.Connection;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PossibleConnectionsService {
    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8084").build();

    public List<Connection> getPossibleConnections() {
        return Arrays.asList(Objects.requireNonNull(webClient.get()
                .uri("/findPossibleConnections")
                .retrieve()
                .bodyToMono(Connection[].class)
                .block()));
    }
}
