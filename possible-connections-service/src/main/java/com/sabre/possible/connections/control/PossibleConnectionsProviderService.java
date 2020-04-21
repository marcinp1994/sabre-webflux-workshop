package com.sabre.possible.connections.control;

import com.sabre.possible.connections.control.calculations.ConnectionCalculatorFactory;
import com.sabre.possible.connections.control.calculations.ConnectionsCalculator;
import com.sabre.possible.connections.entity.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PossibleConnectionsProviderService {
    private final ConnectionCalculatorFactory connectionCalculatorFactory;

    @Autowired
    public PossibleConnectionsProviderService(ConnectionCalculatorFactory connectionCalculatorFactory) {
        this.connectionCalculatorFactory = connectionCalculatorFactory;
    }

    public List<Connection> getPossibleConnections() {
        List<Connection> connections = new ArrayList<>();
        ConnectionsCalculator connectionsCalculator = connectionCalculatorFactory.get();
        while (connectionsCalculator.nextConnectionExists()) {
            connections.add(connectionsCalculator.getNextConnection());
        }
        return connections;
    }
}
