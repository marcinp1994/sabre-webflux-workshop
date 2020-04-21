package com.sabre.possible.connections.web;

import com.sabre.possible.connections.control.PossibleConnectionsProviderService;
import com.sabre.possible.connections.entity.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PossibleConnectionsEndpoint {

    private final PossibleConnectionsProviderService possibleConnectionsService;

    @Autowired
    public PossibleConnectionsEndpoint(PossibleConnectionsProviderService possibleConnectionsService) {
        this.possibleConnectionsService = possibleConnectionsService;
    }

    @GetMapping("/findPossibleConnections")
    public List<Connection> findAllConnections() {
        return possibleConnectionsService.getPossibleConnections();
    }
}
